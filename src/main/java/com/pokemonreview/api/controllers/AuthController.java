package com.pokemonreview.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("login")
    public ResponseEntity<String> login() {
        logger.info("Received a login request"); // Add this line for logging

        // Remove authentication-related code
        // ...

        // Return a response
        return new ResponseEntity<>("Login successful", HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> register() {
        logger.info("Received a register request"); // Add this line for logging

        // Remove authentication-related code
        // ...

        // Return a response
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}
