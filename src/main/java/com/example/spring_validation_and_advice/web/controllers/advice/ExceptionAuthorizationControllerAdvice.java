package com.example.spring_validation_and_advice.web.controllers.advice;

import com.example.spring_validation_and_advice.app.exceptions.InvalidCredentials;
import com.example.spring_validation_and_advice.app.exceptions.UnauthorizedUser;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log
@ControllerAdvice
public class ExceptionAuthorizationControllerAdvice {
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser e) {
        log.info("error authorization");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials e) {
        log.info("invalid credentials");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
