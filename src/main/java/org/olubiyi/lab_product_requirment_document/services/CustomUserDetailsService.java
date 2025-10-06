package org.olubiyi.lab_product_requirment_document.services;

import lombok.RequiredArgsConstructor;
import org.olubiyi.lab_product_requirment_document.models.TalentUser;
import org.olubiyi.lab_product_requirment_document.repositories.TalentUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service  // <-- this makes it a bean
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final TalentUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        TalentUser user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword()) // must already be encoded
                .roles("USER")
                .build();
    }
}
