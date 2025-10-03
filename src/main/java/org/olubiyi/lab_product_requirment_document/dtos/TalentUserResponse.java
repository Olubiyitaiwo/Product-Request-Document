package org.olubiyi.lab_product_requirment_document.dtos;

import lombok.Data;
import org.springframework.context.annotation.Profile;

@Data
public class TalentUserResponse {
    private Long id;
    private String email;
    private Profile profile;
}
