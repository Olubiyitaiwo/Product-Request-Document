package org.olubiyi.lab_product_requirment_document.services;

import lombok.RequiredArgsConstructor;
import org.olubiyi.lab_product_requirment_document.dtos.LoginRequest;
import org.olubiyi.lab_product_requirment_document.dtos.SignUpRequest;
import org.olubiyi.lab_product_requirment_document.dtos.SignUpResponse;
import org.olubiyi.lab_product_requirment_document.models.SignUp;
import org.olubiyi.lab_product_requirment_document.repositories.SignUpRepository;
import org.olubiyi.lab_product_requirment_document.config.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final SignUpRepository signUpRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 🔹 User Registration
    public SignUpResponse signup(SignUpRequest request) {
        if (signUpRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        SignUp user = new SignUp();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        SignUp savedUser = signUpRepository.save(user);

        SignUpResponse response = new SignUpResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        return response;
    }

    // 🔹 User Login
    public String login(LoginRequest request) {
        SignUp user = signUpRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return jwtUtil.generateToken(user.getEmail()); // return JWT
    }

    // 🔹 User Logout (basic demo – in stateless JWT, logout is usually handled by token blacklist/expiry)
    public String logout(String token) {
        // For real projects: implement token blacklist (store invalidated tokens in Redis/DB)
        return "User logged out (token invalidation not implemented)";
    }
}

