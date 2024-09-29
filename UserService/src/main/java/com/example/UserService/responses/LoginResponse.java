package com.example.UserService.responses;

public class LoginResponse {
    private String token;

    private long expiresIn;

    public String getToken() {
        return this.token;
    }

    public long getExpiresIn() {
        return this.expiresIn;
    }

    public void setToken(String newToken) {
        this.token = newToken;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
