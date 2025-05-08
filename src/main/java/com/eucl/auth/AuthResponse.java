package com.eucl.auth;

public class AuthResponse {

    private String token;
    private String userId;

    // Constructor for both token and userId
    public AuthResponse(String token, String userId) {
        this.token = token;
        this.userId = userId;
    }

    // Constructor for just token (optional if still used in login)
    public AuthResponse(String token) {
        this.token = token;
    }

    // Getters & Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
