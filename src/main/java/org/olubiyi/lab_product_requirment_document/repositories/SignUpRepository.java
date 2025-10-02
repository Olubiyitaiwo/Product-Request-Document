package org.olubiyi.lab_product_requirment_document.repositories;

import org.olubiyi.lab_product_requirment_document.models.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignUpRepository extends JpaRepository<SignUp,Long> {
    boolean existsByEmail(String email);
    Optional<SignUp> findByEmail(String email);
}
