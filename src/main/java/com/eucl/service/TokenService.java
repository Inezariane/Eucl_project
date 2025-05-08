package com.eucl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import com.eucl.model.Token;
import com.eucl.repository.TokenRepository;;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    private static final SecureRandom random = new SecureRandom();

    public String generateToken(int amount, String meterNumber) {
        if (amount < 100 || amount % 100 != 0 || amount > 365 * 5 * 100) {
            throw new IllegalArgumentException("Amount must be a multiple of 100 and not exceed 5 years worth of tokens.");
        }

        int days = amount / 100;  // 100 RWF = 1 day of electricity
        String token = generateUniqueToken();

        // Save to DB
        Token purchasedToken = new Token();
        purchasedToken.setMeterNumber(meterNumber);
        purchasedToken.setToken(token);
        purchasedToken.setTokenValueDays(days);
        purchasedToken.setPurchasedDate(LocalDateTime.now());
        purchasedToken.setAmount(amount);

        tokenRepository.save(purchasedToken);

        return token;
    }

    // Helper method to generate unique token
    private String generateUniqueToken() {
        StringBuilder sb = new StringBuilder(16);
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < 16; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}

