package br.edu.ifpb.dac.arthur.house.presentation.controllers;

import br.edu.ifpb.dac.arthur.house.business.interfaces.SystemUserService;
import br.edu.ifpb.dac.arthur.house.business.services.ConverterService;
import br.edu.ifpb.dac.arthur.house.business.services.SystemUserServiceImpl;
import br.edu.ifpb.dac.arthur.house.model.entities.SystemUser;
import br.edu.ifpb.dac.arthur.house.presentation.dtos.SystemUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class SystemUserController {

    private final SystemUserServiceImpl systemUserService;

    private final ConverterService converterService;


    public SystemUserController(SystemUserServiceImpl systemUserService1, ConverterService converterService) {
        this.systemUserService = systemUserService1;
        this.converterService = converterService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid SystemUserDto systemUserDto) {
        try {
            var systemUserModel = this.converterService.systemUserDtoToSystemUserModel(systemUserDto);
            var saveSystemUser = this.systemUserService.save(systemUserModel);
            System.out.println(saveSystemUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(saveSystemUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") UUID id) {
        try {
            var systemUserModel = this.systemUserService.findById(id);
            var systemUserDto = this.converterService.systemUserModelToSystemDto(systemUserModel);
            return ResponseEntity.status(HttpStatus.OK).body(systemUserDto);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }

    @GetMapping
    public ResponseEntity<List<SystemUserDto>> findAll() {
        List<SystemUser> systemUsers = this.systemUserService.findAll();
        List<SystemUserDto> systemUsersDto = this.converterService.systemUsersModelToSystemDtos(systemUsers);
        return ResponseEntity.status(HttpStatus.OK).body(systemUsersDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id")UUID id, @RequestBody @Valid SystemUserDto systemUserDto) {
        try {
            var systemUserModel = this.converterService.systemUserDtoToSystemUserModel(systemUserDto);
            var systemUser = this.systemUserService.update(systemUserModel);
            var newSystemUserDto = this.converterService.systemUserModelToSystemDto(systemUser);
            return ResponseEntity.status(HttpStatus.OK).body(newSystemUserDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id")UUID id) {
        try {
            this.systemUserService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted house");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }
}
