package com.example.spring_validation_and_advice.app.model;

import com.example.spring_validation_and_advice.web.dto.Authorities;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private String login;
    private String password;
    private List<Authorities> authorities;
}
