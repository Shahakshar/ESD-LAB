package com.akshar.restaurantspring.controllers.configuration;

import com.akshar.restaurantspring.respository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration {

    private final UserRepo repo;

    public UserConfiguration(UserRepo repo) {
        this.repo = repo;
    }



}
