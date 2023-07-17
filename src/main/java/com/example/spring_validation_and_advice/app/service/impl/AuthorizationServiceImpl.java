package com.example.spring_validation_and_advice.app.service.impl;

import com.example.spring_validation_and_advice.app.exceptions.InvalidCredentials;
import com.example.spring_validation_and_advice.app.exceptions.UnauthorizedUser;
import com.example.spring_validation_and_advice.app.repository.UserRepository;
import com.example.spring_validation_and_advice.app.service.AuthorizationService;
import com.example.spring_validation_and_advice.web.dto.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    UserRepository userRepository;

    @Autowired
    public AuthorizationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
