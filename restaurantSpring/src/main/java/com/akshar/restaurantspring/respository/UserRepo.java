package com.akshar.restaurantspring.respository;


import com.akshar.restaurantspring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("select u from User u where u.userName = ?1")
    Optional<User> findByUserName(String username);

    @Query("select u from User u")
    ArrayList<User> getAllUser();
}
