package com.example.interceptor.controller;

import com.example.interceptor.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/private")
//@Auth //Auth 가 있다면 Session을 검사해서 권한이 있는 상대만 통과시킨다.
public class PrivateController {

    @Auth // 위에 있어도 되고 밑에 특정 Mapping 값에 있어도 된다.
    //but 일관성이 떨어져서 지양 ->controller에 넣어주거나 특정 url에 넣어주는 것이 best
    @GetMapping("/hello")
    public String hello() {
        log.info("private hello controller");
        return "private hello";
    }

}
