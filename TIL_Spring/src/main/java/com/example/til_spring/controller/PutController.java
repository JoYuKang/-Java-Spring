package com.example.til_spring.controller;

import com.example.til_spring.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/put")
public class PutController {

    @PutMapping("/put") //RequestBody로 데이터를 받아야한다.
    public PostRequestDto put(@RequestBody PostRequestDto postRequestDto) {
        System.out.println(postRequestDto);
        return postRequestDto;
    }
    @PutMapping("/put/{userID}") //RequestBody로 데이터를 받아야한다.
    public PostRequestDto put(@RequestBody PostRequestDto postRequestDto, @PathVariable(name = "userID") long id) {
        System.out.println(id);
        System.out.println(postRequestDto);

        return postRequestDto;
    }

}
