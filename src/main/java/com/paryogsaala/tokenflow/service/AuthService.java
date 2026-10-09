package com.paryogsaala.tokenflow.service;
import com.paryogsaala.tokenflow.dto.LoginRequest;
import com.paryogsaala.tokenflow.dto.LoginResponse;
import com.paryogsaala.tokenflow.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        String demoUsername = "demo";
        String demoPasswordHash = passwordEncoder.encode("password123");

        if (!demoUsername.equals(loginRequest.username()) || !passwordEncoder.matches(loginRequest.password(), demoPasswordHash)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Invalid username or password");
        }
        String token = jwtService.generateAccessToken(loginRequest.username());
        return new LoginResponse(token,"Bearer");
    }
}
