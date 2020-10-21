package com.example.demoapi.security.service;

import com.example.demoapi.entity.UserSystem;
import com.example.demoapi.repository.UserSystemRepository;
import com.example.demoapi.security.entity.UserSystemDetails;
import com.example.demoapi.service.exception.UserNotEnabledException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserSystemRepository userSystemRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Optional<UserSystem> optionalUserSystem = userSystemRepository.findByEmail(email);
        final UserSystem usuario = optionalUserSystem.orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        if(!usuario.isEnabled()) {
            throw new UserNotEnabledException("User not enabled!");
        }

        return new UserSystemDetails(usuario);
    }

}
