package br.edu.ifpb.dac.arthur.house.config;

import br.edu.ifpb.dac.arthur.house.business.interfaces.SystemUserService;
import br.edu.ifpb.dac.arthur.house.business.interfaces.TokenService;
import br.edu.ifpb.dac.arthur.house.model.entities.SystemUser;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

public class TokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    private SystemUserService systemUserService;

    public TokenFilter(TokenService tokenService, SystemUserService systemUserService) {
        super();
        this.tokenService = tokenService;
        this.systemUserService = systemUserService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = this.tokenService.get(request);
        boolean valid = this.tokenService.isValid(token);

        if (valid) authenticate(token);

        filterChain.doFilter(request, response);
    }

    private void authenticate(String token) {
        UUID userId = this.tokenService.getUserId(token);
        SystemUser systemUser = this.systemUserService.findById(userId);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(systemUser, null, systemUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
}
