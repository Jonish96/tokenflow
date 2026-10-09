package com.paryogsaala.tokenflow.security;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JwtServiceTest {
    @Test
    void shouldGenerateAndValidateToken() {

        String secret =
                "MDEyMzQ1Njc4OWFiY2RlZjAxMjM0NTY3ODlhYmNkZWY=";

        JwtService jwtService = new JwtService(secret, 60);

        String token = jwtService.generateAccessToken("demo");

        Claims claims = jwtService.validateAndExtractClaims(token);

        assertNotNull(token);
        assertEquals("demo", claims.getSubject());
    }
}
