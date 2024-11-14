package com.gourmetx.GourmetX.dto;

import com.gourmetx.GourmetX.entities.User;

public class LoginResponse {
    private String token;      
    private String username;  
    private String name;       
    private String email;     

   
    public LoginResponse(String token, String username, String name, String email) {
        this.token = token;
        this.username = username;
        this.name = name;
        this.email = email;
    }

   
    public LoginResponse(String token, String username) {
        this.token = token;
        this.username = username;
        this.name = null;  
        this.email = null; 
    }

    // New constructor that accepts a User object
    public LoginResponse(String token, User user) {
        this.token = token;
        this.username = user.getUsername();
        this.name = user.getUsername();
        this.email = user.getEmail(); 
    }

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
