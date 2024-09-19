package com.learn.hibernate.controller;

import com.learn.hibernate.dto.CourseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseControllerRestAPI {

    @GetMapping("/courses")
    public List<CourseDTO> retrieveAllCourses() {
        return Arrays.asList(
                new CourseDTO(1L, "Learn hibernate", "Ahmed"),
                new CourseDTO(2L, "Learn Java", "Galal")
        );
    }
}