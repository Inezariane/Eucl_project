package com.eucl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.eucl.service.TokenService;

@RestController
@RequestMapping("/api/tokens")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateToken(@RequestParam int amount, @RequestParam String meterNumber) {
        try {
            String token = tokenService.generateToken(amount, meterNumber);
            return ResponseEntity.ok("Token generated: " + token);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
