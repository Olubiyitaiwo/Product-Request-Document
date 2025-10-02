package org.olubiyi.lab_product_requirment_document.models;


import jakarta.persistence.*;
import org.apache.catalina.User;

import java.time.LocalDateTime;

@Entity
    public class VerificationToken {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String token;

        @OneToOne
        @JoinColumn(nullable = false, name = "user_id")
        private SignUp signUp;

        private LocalDateTime expiryDate;
    }


