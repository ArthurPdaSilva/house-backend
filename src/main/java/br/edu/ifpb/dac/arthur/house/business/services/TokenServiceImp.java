package br.edu.ifpb.dac.arthur.house.business.services;

import br.edu.ifpb.dac.arthur.house.business.interfaces.TokenService;
import br.edu.ifpb.dac.arthur.house.model.entities.SystemUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@Service
public class TokenServiceImp implements TokenService {

    public static final String CLAIM_USERID = "userid";
    public static final String CLAIM_USERNAME = "username";
    public static final String CLAIM_EXPIRATION = "expirationTime";

    @Value("${jwt.expiration}")
    private String expiration;
    @Value("${jwt.secret}")
    private String secret;

    @Override
    public String generate(SystemUser systemUser) {
        long expiration = Long.parseLong(this.expiration);
        LocalDateTime expirationlocalDateTime = LocalDateTime.now().plusMinutes(expiration);
        Instant instant = expirationlocalDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date expirationDate = Date.from(instant);
        String tokenExpiration = expirationlocalDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));

        return jwsTokenBuilder(systemUser, tokenExpiration, expirationDate);
    }

    private String jwsTokenBuilder(SystemUser systemUser, String tokenExpiration, Date expirationDate) {
        return Jwts.builder()
                .setExpiration(expirationDate)
                .setSubject(systemUser.getId().toString())
                .claim(CLAIM_USERID, systemUser.getId())
                .claim(CLAIM_USERNAME, systemUser.getUsername())
                .claim(CLAIM_EXPIRATION, tokenExpiration)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    @Override
    public Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts
                .parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public boolean isValid(String token) {
        if(token == null) return false;

        try {
            Claims claims = getClaims(token);
            LocalDateTime expirationDate = claims
                    .getExpiration()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            return !LocalDateTime.now().isAfter(expirationDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public String getUsername(String token) {
        Claims claims = getClaims(token);
        return (String) claims.get(CLAIM_USERNAME);
    }

    @Override
    public UUID getUserId(String token) {
        Claims claims = getClaims(token);
        return UUID.fromString(claims.getSubject());
    }

    @Override
    public String get(HttpServletRequest httpServletRequest) {
        String authorization = httpServletRequest.getHeader("Authorization");

        if(authorization != null && authorization.startsWith("bearer"))
            return authorization.split(" ")[1];
        return null;
    }
}
