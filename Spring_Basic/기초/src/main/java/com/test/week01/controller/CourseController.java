package com.test.week01.controller;

import com.test.week01.prac.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public Course getCourses() {
        Course course = new Course();
        course.setTitle("웹개발의 봄 스프링 시작 튜터");
        course.setDays(26);
        course.setTutor("조유강");
        return course;
    }
}