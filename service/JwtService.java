package com.picafe.team_3.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private static final Logger logger = Logger.getLogger(String.valueOf(JwtService.class));

    @Autowired
    private Environment env;

    private Key SECRET;

    @PostConstruct
    public void init() {
        String secret = env.getProperty("SECRET");
        SECRET = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret));
        logger.log(Level.INFO, "JWT Secret initialized successfully");
    }

    public String generateToken(int employee, String employeeDesignation) {
        String employeeId = String.valueOf(employee);
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", employeeDesignation);
        logger.log(Level.INFO,
                "Generating JWT token for employee ID: " + employeeId + " with designation: " + employeeDesignation);
        return createToken(claims, employeeId);
    }

    private String createToken(Map<String, Object> claims, String employeeId) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(employeeId)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(SECRET, SignatureAlgorithm.HS256).compact();
    }

}
