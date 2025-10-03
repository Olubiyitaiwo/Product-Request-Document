package org.olubiyi.lab_product_requirment_document.services;

import org.olubiyi.lab_product_requirment_document.dtos.TalentUserRequest;
import org.olubiyi.lab_product_requirment_document.dtos.TalentUserResponse;
import org.olubiyi.lab_product_requirment_document.models.TalentUser;
import org.olubiyi.lab_product_requirment_document.models.TalentProfile; // ✅ correct import
import org.olubiyi.lab_product_requirment_document.repositories.TalentUserRepository;
import org.springframework.stereotype.Service;

@Service
public class TalentUserService {

    private final TalentUserRepository talentUserRepository;

    public TalentUserService(TalentUserRepository talentUserRepository) {
        this.talentUserRepository = talentUserRepository;
    }

    public TalentUserResponse createUser(TalentUserRequest talentUserRequest) {
        TalentUser talentUser = new TalentUser();

        talentUser.setEmail(talentUserRequest.getEmail());


        TalentProfile profile = new TalentProfile();
        profile.setTranscript(talentUserRequest.getTalentProfile().getTranscript());
        profile.setStatementOfPurpose(talentUserRequest.getTalentProfile().getStatementOfPurpose());

        talentUser.setProfile(profile);

        talentUserRepository.save(talentUser);

        TalentUserResponse response = new TalentUserResponse();
        response.setId(talentUser.getId());
        response.setEmail(talentUser.getEmail());
        return response;
    }
}
