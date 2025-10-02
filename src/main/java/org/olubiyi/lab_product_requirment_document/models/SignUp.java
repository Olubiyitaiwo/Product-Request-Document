package org.olubiyi.lab_product_requirment_document.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.olubiyi.lab_product_requirment_document.enums.TalentProfile;

@NoArgsConstructor
@Data
@Entity(name = "signUp")
public class SignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private TalentProfile talentProfile =  TalentProfile.USERS;
}
