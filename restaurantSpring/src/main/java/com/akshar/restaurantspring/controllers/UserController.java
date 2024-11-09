package com.akshar.restaurantspring.controllers;

import com.akshar.restaurantspring.models.User;
import com.akshar.restaurantspring.services.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userService.findByUserName(user.getUserName()).isPresent()) {
            return ResponseEntity.badRequest().body("Username Already Taken.");
        }
        User regUser = userService.registerUser(user);
        return ResponseEntity.ok(regUser.getUserName()+" register Successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        return userService.findByUserName(user.getUserName())
                .filter(u -> userService.checkPassword(u, user.getPassword()))
                .map(u -> ResponseEntity.ok(user.getUserName()+" Login Successfully!"))
                .orElse(ResponseEntity.status(401).body("Invalid username or password!"));
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<ArrayList<User>> getAllUsers() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

}
