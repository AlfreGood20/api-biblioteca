package com.api.biblioteca.configurations;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.expirate.access}")
    private long expiracionAccess;

    @Value("${jwt.expirate.refesh}")
    private long expiracionRefresh;

    @Value("${jwt.secret}")
    private String llaveSecreta;

    private Map<String, Object> payload(CustomUserDetails usuario){
        var payload = new HashMap<String, Object>();

        payload.put("nombre_completo",usuario.nombreCompleto() );
        payload.put("rol", usuario.getAuthorities());
        payload.put("foto_url", usuario.fotoUrl());

        return payload;
    }

    private SecretKey firma(){
        return Keys.hmacShaKeyFor(llaveSecreta.getBytes());
    }

    public String generarTokenAccess(CustomUserDetails usuario){
        return Jwts.builder()
            .claims(payload(usuario))
            .subject(usuario.getUsername())
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + expiracionAccess))
            .signWith(firma(), Jwts.SIG.HS256)
            .compact();
    }

    public String generarTokenRefresh(CustomUserDetails usuario){
        return Jwts.builder()
            .subject(usuario.getUsername())
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + expiracionRefresh))
            .signWith(firma(), Jwts.SIG.HS256)
            .compact();
    }

    private Claims obtenerClaims(String token){
        return Jwts.parser()
            .verifyWith(firma())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }

    public String obtenerSuject(String token){
        return obtenerClaims(token).getSubject();
    }

    public boolean esValidoToken(String token, CustomUserDetails usuario){
        Claims claims = obtenerClaims(token);
        String username = claims.getSubject();

        return usuario.getUsername().equals(username) && !(claims.getExpiration().before(new Date()));
    }
}