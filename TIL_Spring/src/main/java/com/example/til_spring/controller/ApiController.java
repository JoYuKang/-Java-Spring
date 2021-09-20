package com.example.til_spring.controller;


import com.example.til_spring.dto.UserRequset;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController //해당 class는 Rest API를 처리하는 Controller
@RequestMapping("/api") // 주소 할당 RequestMapping URI를 지정해주는 Annotation
public class ApiController {

    @GetMapping("/hello") //localhost:8080/api/hello
    public String hello() {
        return "hello spring boot";
    }

    //과거 방식 현재방식 비교
    // @GetMapping("hi") <- @RequestMapping(value = "/hi", method = RequestMethod.GET)
    // 훨씬 간편해지고 RequestMapping으로 사용할 때 method를 붙이지 않으면 GET, POST, DELETE가 전부 작동한다.
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi() {
        return "hi";
    }

    //http://localhost:9090/api/path-variable/{name}
    //{name}은 변수
    @GetMapping("/path-variable/{name}") // 주소에는 대문자를 사용하지 않는다. 대신 '-'를 사용하여 가독성 확보!
    // 기본적으로 Mapping의 뒤 변수명과 @PathVariable의 변수명은 같아야하지만 변경하고 싶으면
    // 아래와 같이 관호() 안에 변수 name = ""안에 Mapping 변수 명을 똑같이 입력해주면 사용이 가능하다.
    // ex) @GetMapping("/path-variable/{id}")이면
    // public String pathVrioable(@PathVariable(name = "id") String pathid) 로 변경하면 된다.
    public String pathVrioable(@PathVariable(name = "name") String pathname) {
        // ln 은 %s 사용 불가
        System.out.println("path-variable name : " + pathname);

        // System.out.printf("path-variable name : %s", name);
        // System.out.printf("path-variable name : %s", name);

        return pathname;
    }

    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");
            sb.append(entry.getKey()).append(" = ").append(entry.getValue()).append("\n");
            System.out.println(sb);
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        System.out.println(name);
        System.out.println(age);
        System.out.println(email);

        return name + " " + age + " " + email;
    }

    @GetMapping("query-param03")
    //UserRequset에는  @RequestParam을 사용하지 않는다.
    //?name=홍길동&email=ykang9533@naver.com&age=26
    public String queryParam03(UserRequset userRequset) {
        System.out.println(userRequset.getName());
        System.out.println(userRequset.getEmail());
        System.out.println(userRequset.getAge());

        return userRequset.toString();
    }
}
