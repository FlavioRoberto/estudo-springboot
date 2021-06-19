package com.flavio.estudos.spring.hr.hroauth.services;

import com.flavio.estudos.spring.hr.hroauth.config.exceptions.UserNotFoundException;
import com.flavio.estudos.spring.hr.hroauth.entities.User;
import com.flavio.estudos.spring.hr.hroauth.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) throws UserNotFoundException {
        var user = userFeignClient.findByEmail(email).getBody();

        if(user == null)
            throw new UserNotFoundException("user not found");

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userFeignClient.findByEmail(username).getBody();

        if(user == null)
            throw new UsernameNotFoundException("user not found");

        return user;
    }
}
