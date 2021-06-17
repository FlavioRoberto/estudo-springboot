package com.flavio.estudos.spring.hr.hruser.hruser.controllers;

import com.flavio.estudos.spring.hr.hruser.hruser.entities.User;
import com.flavio.estudos.spring.hr.hruser.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = repository.findById(id).get();
        return  ResponseEntity.ok(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        User user = repository.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}