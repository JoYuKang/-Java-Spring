package com.example.til_spring.controller;

import com.example.til_spring.dto.UserRequset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    @ResponseBody
    @GetMapping("/user")
    public UserRequset userRequset() {
        var user = new UserRequset();
        user.setName("steve");

        return user;

    }

}
