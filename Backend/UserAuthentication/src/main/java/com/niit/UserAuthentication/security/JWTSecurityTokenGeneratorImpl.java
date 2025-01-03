package com.niit.UserAuthentication.security;

import com.niit.UserAuthentication.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTSecurityTokenGeneratorImpl implements SecurityTokenGenerator {

    // Generate a secure key
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @Override
    public Map<String, String> generateToken(User user) {
        String jwtToken = Jwts.builder()
                .setIssuer("UserProduct")
                .setSubject(user.getEmailId())
                .setIssuedAt(new Date())
                .signWith(key) // Use secure key
                .compact();

        Map<String, String> map = new HashMap<>();
        map.put("token", jwtToken);
        map.put("message", "Authentication Successful");
        return map;
    }
}
