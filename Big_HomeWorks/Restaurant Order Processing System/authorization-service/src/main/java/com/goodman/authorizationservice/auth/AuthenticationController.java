package com.goodman.authorizationservice.auth;

import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    @PostMapping("/register")
    public ResponseEntity<?> register (
            @RequestBody RegisterRequest request
    ) {
        try {
            return ResponseEntity.ok(service.register(request));

        } catch (ConstraintViolationException e) {
            return ResponseEntity.badRequest().body("Invalid data of user");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Unknown mistake");
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> register (
            @RequestBody AuthenticationRequest request
    ) {
        try {
            return ResponseEntity.ok(service.authenticate(request));
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body("Invalid data of user");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Unknown mistake");
        }
    }
}
