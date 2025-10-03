package org.olubiyi.lab_product_requirment_document.controllers;

import lombok.RequiredArgsConstructor;
import org.olubiyi.lab_product_requirment_document.dtos.TalentUserRequest;
import org.olubiyi.lab_product_requirment_document.dtos.TalentUserResponse;
import org.olubiyi.lab_product_requirment_document.services.TalentUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users") // base URL
public class TalentUserController {

    private final TalentUserService talentUserService;

    @PostMapping("/create")
    public ResponseEntity<TalentUserResponse> createTalentUser(@RequestBody TalentUserRequest talentUserRequest) {
        TalentUserResponse response = talentUserService.createUser(talentUserRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
