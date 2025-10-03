package org.olubiyi.lab_product_requirment_document.services;

import lombok.RequiredArgsConstructor;
import org.olubiyi.lab_product_requirment_document.dtos.TalentUserRequest;
import org.olubiyi.lab_product_requirment_document.dtos.TalentUserResponse;
import org.olubiyi.lab_product_requirment_document.models.TalentUser;
import org.olubiyi.lab_product_requirment_document.repositories.TalentUserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TalentUserService {

    private final TalentUserRepository talentUserRepository;

    public TalentUserResponse createUser(TalentUserRequest talentUserRequest) {
        // Map request → entity
        TalentUser talentUser = new TalentUser();

        talentUser.setEmail(talentUserRequest.getEmail());
        talentUser.setProfile(talentUserRequest.getProfile());

        // Save to DB
        TalentUser savedUser = talentUserRepository.save(talentUser);

        // Map entity → response
        TalentUserResponse response = new TalentUserResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setProfile(savedUser.getProfile());

        return response;
    }
}
