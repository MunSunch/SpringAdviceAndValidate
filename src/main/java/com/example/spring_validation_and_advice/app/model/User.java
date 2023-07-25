package com.example.spring_validation_and_advice.app.model;

import com.example.spring_validation_and_advice.web.dto.Authorities;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    @NotBlank
    private String login;
    @NotBlank
    private String password;

    private List<Authorities> authorities;
}
