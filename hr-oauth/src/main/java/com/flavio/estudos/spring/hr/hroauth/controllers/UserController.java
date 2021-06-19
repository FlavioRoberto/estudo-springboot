package com.flavio.estudos.spring.hr.hroauth.controllers;

import com.flavio.estudos.spring.hr.hroauth.config.UserNotFoundException;
import com.flavio.estudos.spring.hr.hroauth.entities.User;
import com.flavio.estudos.spring.hr.hroauth.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserServices service;

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        try {
            var user = service.findByEmail(email);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }
}
