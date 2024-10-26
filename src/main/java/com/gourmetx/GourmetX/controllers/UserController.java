package com.gourmetx.GourmetX.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gourmetx.GourmetX.entities.User;
import com.gourmetx.GourmetX.repositories.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {
        Optional<User> user = userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        
        if (user.isPresent()) {
            // Aqui você pode gerar e retornar um token, ou os dados do usuário, conforme necessário.
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }
}
