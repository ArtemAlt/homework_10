package ru.education.homework_10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Homework10Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework10Application.class, args);
    }

}
