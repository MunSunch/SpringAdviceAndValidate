package com.example.spring_validation_and_advice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class SpringValidationAndAdviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringValidationAndAdviceApplication.class, args);
    }
}
