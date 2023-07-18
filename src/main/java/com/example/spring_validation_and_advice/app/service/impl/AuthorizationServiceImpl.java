package com.example.spring_validation_and_advice.app.service.impl;

import com.example.spring_validation_and_advice.app.exceptions.UnauthorizedUser;
import com.example.spring_validation_and_advice.app.repository.UserRepository;
import com.example.spring_validation_and_advice.app.service.AuthorizationService;
import com.example.spring_validation_and_advice.web.dto.Authorities;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Log
@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    UserRepository userRepository;

    @Autowired
    public AuthorizationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        log.info("getAuthorities("+ user+", "+password+")");
        return userRepository.getUserAuthorities(user, password).orElseThrow(()->{
            log.info("error authorization user="+user);
            throw new UnauthorizedUser("Unknown user " + user);
        });
    }
}