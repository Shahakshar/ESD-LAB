package com.akshar.restobistro.services;

import com.akshar.restobistro.models.User;
import com.akshar.restobistro.repo.UserRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public boolean updateUser(String email, User updateUser) {
        int value = userRepository.updateUserByEmail(email, updateUser.getFullName(), new Date());
        return value > 0;
    }

    @Transactional
    public boolean deleteUserByEmail(String email) {
        int value = userRepository.deleteUserByEmail(email);
        return value > 0;
    }

}
