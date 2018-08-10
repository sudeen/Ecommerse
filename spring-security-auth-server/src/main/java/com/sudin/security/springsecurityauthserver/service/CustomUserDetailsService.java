package com.sudin.security.springsecurityauthserver.service;

import com.sudin.security.springsecurityauthserver.model.CustomUserDetails;
import com.sudin.security.springsecurityauthserver.model.Users;
import com.sudin.security.springsecurityauthserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> usersOptional = userRepository.findByName(username);
        usersOptional
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        return usersOptional.map(CustomUserDetails::new)
                .get();
    }
}
