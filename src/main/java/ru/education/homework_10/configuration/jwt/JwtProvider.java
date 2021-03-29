package ru.education.homework_10.configuration.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
@Component
public class JwtProvider {


    @Value("${jwt.secret}")
    private String jwtKey;


    public String generateToken(String login){
        Date date = Date.from(LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512,jwtKey)
                .compact();
    }

    public boolean chekToken(String token){
        try {
            Jwts.parser().setSigningKey(jwtKey).parseClaimsJws(token);
            return true;
        } catch (Exception e){
            log.info("invalid token");
        }
        return false;
    }

    public String getLoginFromToken(String token){
        Claims claims = Jwts.parser().setSigningKey(jwtKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
