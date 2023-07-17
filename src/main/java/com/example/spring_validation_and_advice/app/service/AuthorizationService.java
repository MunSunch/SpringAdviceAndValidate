package com.example.spring_validation_and_advice.app.service;

import com.example.spring_validation_and_advice.web.dto.Authorities;

import java.util.List;

public interface AuthorizationService {
    List<Authorities> getAuthorities(String user, String password);
}
