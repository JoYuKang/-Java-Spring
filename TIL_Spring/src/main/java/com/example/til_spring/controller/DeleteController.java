package com.example.til_spring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delete")
public class DeleteController {

    @DeleteMapping("/delete/{userID}")
    // @PathVariable의 경우 url에서 각 구분자에 들어오는 값을 처리
    // @RequestParam의 경우 url 뒤에 붙는 파라메터의 값을 가져올 때 사용
    public void delete(@PathVariable String userID, @RequestParam String account) {

        System.out.println(userID);
        System.out.println(account);
        //역등성이기 떄문에 항상 200의 값을 보내준다.(get과 동일하지만 리소스가 없는 상태에서도 200 ok를 보낸다.)
    }
}
