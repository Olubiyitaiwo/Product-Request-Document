package org.olubiyi.lab_product_requirment_document.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "talent_user")
@NoArgsConstructor
@Data
public class TalentUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "talent_profile_id", referencedColumnName = "id")
    private TalentProfile profile;
}
