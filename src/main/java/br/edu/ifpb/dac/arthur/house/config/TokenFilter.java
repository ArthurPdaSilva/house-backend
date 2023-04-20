package br.edu.ifpb.dac.arthur.house.config;

import br.edu.ifpb.dac.arthur.house.business.interfaces.SystemUserService;
import br.edu.ifpb.dac.arthur.house.business.interfaces.TokenService;
import br.edu.ifpb.dac.arthur.house.model.entities.SystemUser;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = this.tokenService.get(request);
        boolean valid = this.tokenService.isValid(token);

        if(valid) {
            authenticate(token);
        }
        filterChain.doFilter(request, response);

    }

    private void authenticate(String token) {

        UUID userid = this.tokenService.getUserId(token);
        SystemUser user = this.systemUserService.findById(userid);

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null,user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

    }

}
