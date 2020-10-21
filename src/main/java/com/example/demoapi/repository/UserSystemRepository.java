package com.example.demoapi.repository;

import com.example.demoapi.entity.UserSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSystemRepository extends JpaRepository<UserSystem, Long> {

    Optional<UserSystem> findByEmail(String email);
}
