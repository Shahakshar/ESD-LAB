package com.akshar.restobistro.controller;

import com.akshar.restobistro.models.User;
import com.akshar.restobistro.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customers")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

    @PutMapping("/update/user")
    public ResponseEntity<String> updateUser(@RequestBody User updateUser) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        String email = currentUser.getEmail();

        boolean updated = customerService.updateUser(email, updateUser);

        if (updated) {
            return ResponseEntity.ok("User updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/user/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
        boolean deleteUser = customerService.deleteUserByEmail(email);

        if (deleteUser) {
            return ResponseEntity.ok("User Deleted Successfully");
        }

        return ResponseEntity.notFound().build();
    }

}
