package br.edu.ifpb.dac.arthur.house.business.services;

import br.edu.ifpb.dac.arthur.house.business.interfaces.AuthenticateService;
import br.edu.ifpb.dac.arthur.house.business.interfaces.SystemUserService;
import br.edu.ifpb.dac.arthur.house.business.interfaces.TokenService;
import br.edu.ifpb.dac.arthur.house.model.entities.SystemUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {

    private final SystemUserService systemUserService;

    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;


    public AuthenticateServiceImpl(SystemUserService systemUserService, TokenService tokenService, AuthenticationManager authenticationManager) {
        this.systemUserService = systemUserService;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String login(String username, String password) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, password));

        SystemUser systemUser = systemUserService.findByUsername(username);
        return  tokenService.generate(systemUser);
    }

    @Override
    public SystemUser getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (SystemUser) authentication.getPrincipal();
    }
}
