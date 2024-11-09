package com.akshar.restaurantspring.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class customerController {

    @GetMapping("/")
    public String greeting(HttpServletRequest request) {
        return "HELLO this is akshar here!"+request.getSession().getId();
    }

}
