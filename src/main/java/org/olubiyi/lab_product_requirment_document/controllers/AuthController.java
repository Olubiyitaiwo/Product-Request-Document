package org.olubiyi.lab_product_requirment_document.controllers;

import lombok.RequiredArgsConstructor;
import org.olubiyi.lab_product_requirment_document.dtos.LoginRequest;
import org.olubiyi.lab_product_requirment_document.dtos.SignUpRequest;
import org.olubiyi.lab_product_requirment_document.dtos.SignUpResponse;
import org.olubiyi.lab_product_requirment_document.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        return ResponseEntity.ok(authService.logout(token));
    }
}
