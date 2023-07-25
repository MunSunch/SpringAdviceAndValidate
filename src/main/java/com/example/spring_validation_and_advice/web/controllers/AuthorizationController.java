package com.example.spring_validation_and_advice.web.controllers;

import com.example.spring_validation_and_advice.app.model.User;
import com.example.spring_validation_and_advice.app.service.AuthorizationService;
import com.example.spring_validation_and_advice.web.controllers.validate.EmptyUser;
import com.example.spring_validation_and_advice.web.dto.Authorities;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
@Validated
@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    @Autowired
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @PostMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestBody @Valid User user) {
        log.info("GET /authorize user="+user.getLogin());
        return service.getAuthorities(user.getLogin(), user.getPassword());
    }
}
