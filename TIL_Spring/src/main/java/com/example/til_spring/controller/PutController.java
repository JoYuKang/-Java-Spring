package com.example.til_spring.controller;

import com.example.til_spring.dto.PostRequestDto;
import com.example.til_spring.dto.UserRequset;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/put")
public class PutController {

    //ResponseEntity를 이용해서 Response 값을 내려받는다.
    @PutMapping("/json")
    public ResponseEntity<UserRequset> put(@RequestBody UserRequset userRequset) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequset);
    }

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
