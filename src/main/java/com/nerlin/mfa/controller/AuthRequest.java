package com.nerlin.mfa.controller;

public class AuthRequest {
    private String username;
    private String password;

    // Getter e setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
