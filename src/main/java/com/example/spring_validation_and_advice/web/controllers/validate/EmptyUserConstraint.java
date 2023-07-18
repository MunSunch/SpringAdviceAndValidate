package com.example.spring_validation_and_advice.web.controllers.validate;

import com.example.spring_validation_and_advice.app.exceptions.InvalidCredentials;
import com.example.spring_validation_and_advice.app.model.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Log
@Service
public class EmptyUserConstraint implements ConstraintValidator<EmptyUser, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        log.info("validate user="+user);
        if(isEmpty(user.getLogin())) {
            log.info("Invalid login="+user.getLogin());
            throw new InvalidCredentials("Invalid login="+user.getLogin());
        }
        if(isEmpty(user.getPassword())) {
            log.info("Invalid password="+user.getPassword());
            throw new InvalidCredentials("Invalid password="+user.getPassword());
        }
        return true;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
