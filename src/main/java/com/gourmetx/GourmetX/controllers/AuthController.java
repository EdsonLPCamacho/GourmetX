package com.gourmetx.GourmetX.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gourmetx.GourmetX.dto.LoginRequest;
import com.gourmetx.GourmetX.dto.LoginResponse;
import com.gourmetx.GourmetX.entities.User;
import com.gourmetx.GourmetX.services.AuthService;
import com.gourmetx.GourmetX.services.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;

    @Autowired
    private UserService userService;
    
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authService.login(loginRequest);

        if (loginResponse != null) {
            return ResponseEntity.ok(loginResponse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
        }
    }

    /*
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> userOptional = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        
        if (userOptional.isPresent()) {
  
            return ResponseEntity.ok(userOptional.get());
        } else {
       
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
        }
    }
    */
}

