package com.example.vaildation.controller;

import com.example.vaildation.dto.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;

@RestController
@RequestMapping("/api")
public class ApiController {


    @GetMapping("/user")// required = false면 값이 없어도 에러 없이 작동한다. 기본적으로는 true를 사용
    public User user(@RequestParam(required = true) String name, @RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);

        System.out.println();

        return user;
    }

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError fieldError = (FieldError) objectError;
                String message = objectError.getDefaultMessage();
                System.out.println("fieldError : " + fieldError.getField());
                System.out.println(message);

                sb.append("field : ").append(fieldError.getField());
                sb.append("message : ").append(message);

            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }
        System.out.println(user);

        return ResponseEntity.ok(user);
    }


}
