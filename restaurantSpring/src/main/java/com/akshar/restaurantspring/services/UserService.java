package com.akshar.restaurantspring.services;

import com.akshar.restaurantspring.models.User;
import com.akshar.restaurantspring.respository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements PasswordEncoder {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Optional<User> findByUserName(String username) {
        return userRepo.findByUserName(username);
    }

    public User registerUser(User user) {
//        System.out.println(user.getPassword()+" I am register with this password");
        user.setPassword(encode(user.getPassword()));
        return userRepo.save(user);
    }

    public boolean checkPassword(User user, String rawPassword) {
        boolean value = matches(rawPassword, user.getPassword());
//        System.out.println(value);
        return value;
    }

    public ArrayList<User> getAllUsers() {
        return userRepo.getAllUser();
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return new BCryptPasswordEncoder().encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
    }
}
