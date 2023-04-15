package br.edu.ifpb.dac.arthur.house.business.interfaces;


import br.edu.ifpb.dac.arthur.house.model.entities.SystemUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;

import java.util.UUID;

public interface TokenService {
    String generate(SystemUser systemUser);
    Claims getClaims(String token) throws ExpiredJwtException;
    boolean isValid(String token);
    String getUsername(String token);
    UUID getUserId(String token);
    String get(HttpServletRequest httpServletRequest);

}
