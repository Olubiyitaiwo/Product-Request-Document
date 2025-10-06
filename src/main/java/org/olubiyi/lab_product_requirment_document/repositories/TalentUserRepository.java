package org.olubiyi.lab_product_requirment_document.repositories;

import org.olubiyi.lab_product_requirment_document.models.TalentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TalentUserRepository extends JpaRepository<TalentUser, Long> {
    Optional<TalentUser> findByEmail(String email);
}
