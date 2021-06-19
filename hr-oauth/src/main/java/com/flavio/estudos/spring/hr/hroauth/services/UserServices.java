package com.flavio.estudos.spring.hr.hroauth.services;

import com.flavio.estudos.spring.hr.hroauth.config.UserNotFoundException;
import com.flavio.estudos.spring.hr.hroauth.entities.User;
import com.flavio.estudos.spring.hr.hroauth.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) throws UserNotFoundException {
        var user = userFeignClient.findByEmail(email).getBody();

        if(user == null)
            throw new UserNotFoundException("user not found");

        return user;
    }
}
