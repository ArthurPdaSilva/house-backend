package br.edu.ifpb.dac.arthur.house.presentation.controllers;


import br.edu.ifpb.dac.arthur.house.business.interfaces.AuthenticateService;
import br.edu.ifpb.dac.arthur.house.business.interfaces.SystemUserService;
import br.edu.ifpb.dac.arthur.house.business.interfaces.TokenService;
import br.edu.ifpb.dac.arthur.house.business.services.ConverterService;
import br.edu.ifpb.dac.arthur.house.model.entities.SystemUser;
import br.edu.ifpb.dac.arthur.house.presentation.dtos.LoginDto;
import br.edu.ifpb.dac.arthur.house.presentation.dtos.SystemUserDto;
import br.edu.ifpb.dac.arthur.house.presentation.dtos.TokenDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
public class AuthenticationController {

    private final AuthenticateService authenticateService;

    private final ConverterService converterService;

    private final SystemUserService systemUserService;

    private final TokenService tokenService;

    public AuthenticationController(AuthenticateService authenticateService, ConverterService converterService, SystemUserService systemUserService, TokenService tokenService) {
        this.authenticateService = authenticateService;
        this.converterService = converterService;
        this.systemUserService = systemUserService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDto loginDto) {
        try {
            String token = this.authenticateService.login(loginDto.getUsername(), loginDto.getPassword());
            SystemUser systemUser = this.systemUserService.findByUsername(loginDto.getUsername());
            SystemUserDto systemUserDto = this.converterService.systemUserModelToSystemDto(systemUser);

            TokenDTO tokenDTO = new TokenDTO(token, systemUserDto);
            return ResponseEntity.status(HttpStatus.OK).body(tokenDTO.getToken());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/isTokenValid")
    public ResponseEntity<Object> isTokenValid(@RequestBody @Valid TokenDTO tokenDTO) {
        try {
            boolean isValid = this.tokenService.isValid(tokenDTO.getToken());
            String message = "Token: " + tokenDTO.getToken();
            message += isValid ? " is valid" : " is invalid";

            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
