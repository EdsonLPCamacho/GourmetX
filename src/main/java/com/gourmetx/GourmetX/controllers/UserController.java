package com.gourmetx.GourmetX.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gourmetx.GourmetX.dto.LoginRequest;
import com.gourmetx.GourmetX.dto.LoginResponse;
import com.gourmetx.GourmetX.entities.User;
import com.gourmetx.GourmetX.repositories.UserRepository;
import com.gourmetx.GourmetX.services.JwtService; 

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService; 

    
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
	

    @PostMapping("/signin")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
  
        Optional<User> user = userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());

        if (user.isPresent()) {
            // Generate the JWT token
            String token = jwtService.generateToken(user.get().getUsername());
            // Create a LoginResponse object that includes the token and the user information
            LoginResponse loginResponse = new LoginResponse(token, user.get());
            // Return the LoginResponse object with a 200 OK status
            return ResponseEntity.ok(loginResponse);
        } else {
            // Create a LoginResponse object with null values if the credentials are invalid
            LoginResponse loginResponse = new LoginResponse(null, null, null, null);
            // Return a 401 response
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
        }
    }



    
}
