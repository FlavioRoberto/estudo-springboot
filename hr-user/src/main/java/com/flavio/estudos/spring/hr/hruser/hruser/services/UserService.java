package com.flavio.estudos.spring.hr.hruser.hruser.services;

import com.flavio.estudos.spring.hr.hruser.hruser.entities.User;
import com.flavio.estudos.spring.hr.hruser.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(long id) {
        return userRepository.findById(id).get();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
