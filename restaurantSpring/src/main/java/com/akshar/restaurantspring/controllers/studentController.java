package com.akshar.restaurantspring.controllers;

import com.akshar.restaurantspring.models.Students;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class studentController {

    private List<Students> students = new ArrayList<>(List.of(
        new Students("1", "akshar", "90"),
        new Students("2", "deepansh", "90"),
        new Students("3", "parth", "90")
    ));

    @GetMapping
    public List<Students> getStudents() {
        return students;
    }

    @PostMapping
    public Students addStudent(@RequestBody Students student) {
        students.add(student);
        return student;
    }
}
