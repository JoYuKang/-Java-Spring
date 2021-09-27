package com.example.filter.controller;

import com.example.filter.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //log 사용 가능
@RestController
@RequestMapping("/api")
public class ApiUseController {

    @PostMapping("/temp")
    public User user(@RequestBody User user){
        log.info("temp : {} ",user);

        return user;
    }

}
