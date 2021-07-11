package com.example.demo.controller;

import com.example.demo.prac.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @GetMapping("/myinfo")
    public Person getPerson() {
        Person person = new Person();
        person.setAddress("인천광역시 남동구");
        person.setAge(26);
        person.setName("조유강");
        person.setJob("학생");
        return person;
    }
}
