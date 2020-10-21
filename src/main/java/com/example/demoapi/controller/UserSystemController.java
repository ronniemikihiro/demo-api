package com.example.demoapi.controller;

import com.example.demoapi.entity.UserSystem;
import com.example.demoapi.service.UserSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-systems")
public class UserSystemController {

    @Autowired
    private UserSystemService userSystemService;

    @GetMapping
    public ResponseEntity<List<UserSystem>> findAll() {
        return ResponseEntity.ok().body(userSystemService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserSystem> findById(@PathVariable Long id) {
        final UserSystem userSystem = userSystemService.findById(id);
        return ResponseEntity.ok().body(userSystem);
    }

    @PostMapping
    public ResponseEntity<UserSystem> create(@RequestBody UserSystem userSystem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userSystemService.save(userSystem));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserSystem> update(@RequestBody UserSystem userSystem) {
        return ResponseEntity.ok().body(userSystemService.update(userSystem));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userSystemService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
