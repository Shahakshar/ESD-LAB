package com.akshar.restobistro.services;

import com.akshar.restobistro.models.User;
import com.akshar.restobistro.repo.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final UserRepository userRepository;

    public CustomerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean updateUser(String email, User updateUser) {
        Optional<User> userExists = userRepository.findByEmail(email);
//        System.out.println(updateUser + "\n\n" + userExists);
        if (userExists.isPresent()) {
            System.out.println(updateUser + "\n\n" + userExists);
            User user = userExists.get();
            user.setFullName(updateUser.getFullName());
            user.setEmail(updateUser.getEmail());
            user.setUpdatedAt(new Date());
            System.out.println(user);
            userRepository.save(user);
            return true;
        }
        return false;
    }

}
