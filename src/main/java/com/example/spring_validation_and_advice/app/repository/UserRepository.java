package com.example.spring_validation_and_advice.app.repository;

import com.example.spring_validation_and_advice.web.dto.Authorities;

import java.util.List;

public interface UserRepository {
    List<Authorities> getUserAuthorities(String user, String password);
    boolean auth(String user, String password);
}
