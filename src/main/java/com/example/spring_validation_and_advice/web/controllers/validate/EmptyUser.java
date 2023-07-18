package com.example.spring_validation_and_advice.web.controllers.validate;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmptyUserConstraint.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmptyUser {
    String message() default "Empty user";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}