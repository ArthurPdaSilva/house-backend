package br.edu.ifpb.dac.arthur.house.config;

import br.edu.ifpb.dac.arthur.house.business.interfaces.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerA {

    @Autowired
    private TokenService tokenService;
}
