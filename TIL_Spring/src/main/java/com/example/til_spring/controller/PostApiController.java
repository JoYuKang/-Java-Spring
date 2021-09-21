package com.example.til_spring.controller;

import com.example.til_spring.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController //해당 class는 Rest API를 처리하는 Controller
@RequestMapping("/api/post")
public class PostApiController {

    @PostMapping("/post") //POST는 BODY에 값이 들어가기 때문에 RequestBody를 넣어 줘야 값을 가져올 수 있다.
    public void post(@RequestBody PostRequestDto postRequestDto) {


        System.out.println(postRequestDto.toString());
        //밑에 식을 간편화
//        requestData.forEach((key, value) -> {
//            System.out.println("key : " + key);
//            System.out.println("value : " + value);
//        });
//        requestData.entrySet().forEach(stringObjectEntry -> {
//            System.out.println("key : " + stringObjectEntry.getKey());
//            System.out.println("key : " + stringObjectEntry.getValue());
//
//        });
    }


}
