package com.example.spring_validation_and_advice.app.repository.impl;

import com.example.spring_validation_and_advice.app.model.User;
import com.example.spring_validation_and_advice.app.repository.UserRepository;
import com.example.spring_validation_and_advice.web.dto.Authorities;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private ConcurrentHashMap<String, User> users;

    public UserRepositoryImpl() {
        users = new ConcurrentHashMap<>();
    }

    @PostConstruct
    public void postInit() {
        users.put("root", new User("root", "root", List.of(Authorities.READ,Authorities.DELETE,Authorities.WRITE)));
        users.put("guest", new User("guest", "123", List.of(Authorities.READ)));
    }

    @Override
    public List<Authorities> getUserAuthorities(String user, String password) {
        if(auth(user, password))
            return users.get(user).getAuthorities();
        return null;
    }

    public boolean auth(String user, String password) {
        return password.equals(users.get(user).getPassword());
    }
}