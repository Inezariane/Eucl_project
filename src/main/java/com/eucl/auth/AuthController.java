package com.eucl.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class AuthController {
    
    private final AuthService authService;
    public AuthController(AuthService authService){
        this.authService = authService;
    }
    @PostMapping("/api/auth/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        try {
            AuthResponse authResponse = authService.register(request);
            return ResponseEntity.ok(authResponse);
        } catch (Exception e) {
            return new ResponseEntity<>(new AuthResponse("Registration failed: " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/api/auth/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
        try {
            AuthResponse authResponse = authService.login(request);
            return ResponseEntity.ok(authResponse);
        } catch (Exception e) {
            return new ResponseEntity<>(new AuthResponse("Login failed: " + e.getMessage()), HttpStatus.UNAUTHORIZED);
        }
    }
}
