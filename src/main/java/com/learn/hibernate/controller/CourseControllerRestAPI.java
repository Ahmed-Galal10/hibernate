package com.learn.hibernate.controller;

import com.learn.hibernate.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseControllerRestAPI {
    @GetMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1L, "Learn hibernate", "Ahmed"),
                new Course(2L, "Learn Java", "Galal")
        );
    }
}