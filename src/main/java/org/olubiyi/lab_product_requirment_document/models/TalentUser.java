package org.olubiyi.lab_product_requirment_document.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;

@Entity(name = "talent_user")
@NoArgsConstructor
@Data
public class TalentUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "talent_profile", referencedColumnName = "id")
    private Profile profile;
}
