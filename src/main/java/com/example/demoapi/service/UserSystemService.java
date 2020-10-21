package com.example.demoapi.service;

import com.example.demoapi.entity.UserSystem;
import com.example.demoapi.repository.UserSystemRepository;
import com.example.demoapi.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSystemService {

    @Autowired
    private UserSystemRepository userSystemRepository;

    public List<UserSystem> findAll() {
        return userSystemRepository.findAll();
    }

    public UserSystem findById(Long id) {
        Optional<UserSystem> user = userSystemRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
    }

    public UserSystem save(UserSystem userSystem) {
        return userSystemRepository.save(userSystem);
    }

    public UserSystem update(UserSystem userSystemUpdated) {
        final Optional<UserSystem> userSystem = userSystemRepository.findById(userSystemUpdated.getId());
        return userSystem.map(u ->
                userSystemRepository.save(
                        UserSystem.builder()
                            .username(u.getUsername())
                            .email(u.getEmail())
                            .password(u.getPassword())
                            .build()
                )).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
    }

    public void delete(Long id) {
        final Optional<UserSystem> userSystem = userSystemRepository.findById(id);
        userSystem.map(u -> {
                userSystemRepository.delete(u);
                return Void.TYPE;
        }).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
    }

}
