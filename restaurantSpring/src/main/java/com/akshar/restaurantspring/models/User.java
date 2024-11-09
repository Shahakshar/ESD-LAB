package com.akshar.restaurantspring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "email")
    private String email;

    @Column(nullable = false, unique = true, name = "user_name")
    private String userName;

    @Column(nullable = false, name = "password")
    private String password;

}
