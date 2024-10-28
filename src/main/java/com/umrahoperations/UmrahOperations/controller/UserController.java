package com.umrahoperations.UmrahOperations.controller;

import com.umrahoperations.UmrahOperations.dto.AuthResponseDTO;
import com.umrahoperations.UmrahOperations.dto.SignInDTO;
import com.umrahoperations.UmrahOperations.model.User;
import com.umrahoperations.UmrahOperations.repository.UserRepository;
import com.umrahoperations.UmrahOperations.service.UserService;
import com.umrahoperations.UmrahOperations.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class UserController {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SignInDTO request) {
        try {
            AuthResponseDTO authResponse  = userService.authenticate(request.getEmailId(), request.getPassword());

            return ResponseEntity.ok(authResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/verify")
    public ResponseEntity<?> verifyToken(@RequestHeader("Authorization") String authHeader) {
        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);
                String emailId = jwtUtils.extractEmailId(token);

                if (jwtUtils.isTokenValid(token, emailId)) {
                    Map<String, Object> response = new HashMap<>();
                    response.put("valid", true);
                    response.put("emailId", emailId);
                    return ResponseEntity.ok(response);
                }
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Token verification failed: " + e.getMessage());
        }
    }


    @GetMapping("/test-db")
    public ResponseEntity<String> testDbConnection() {
        try {
            long userCount = userRepository.count();
            return ResponseEntity.ok("Database connection successful. Found " + userCount + " users.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Database connection failed: " + e.getMessage());
        }
    }

}
