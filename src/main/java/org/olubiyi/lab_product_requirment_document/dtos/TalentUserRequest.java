package org.olubiyi.lab_product_requirment_document.dtos;

import lombok.Data;
import org.olubiyi.lab_product_requirment_document.models.TalentProfile;

@Data
public class TalentUserRequest {
    private String email;
    private TalentProfile talentProfile;
}
