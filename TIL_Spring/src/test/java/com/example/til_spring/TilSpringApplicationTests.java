package com.example.til_spring;

import com.example.til_spring.dto.UserRequset;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.image.TileObserver;
import java.util.Arrays;

@SpringBootTest
class TilSpringApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("------------");

        // text JSON -> Object
        // Object -> Text JSON

        //자동 변환
        //controller request JSON -> Object
        // response Object -> JSON(text)


        //object -> text
        //object mapper get method 를 활용
        var objectMapper = new ObjectMapper();

        var user1 = new UserRequset("Yu", "zzzjsa533@naver.com");
        var user2 = new UserRequset("kang", "ykang9533@naver.com","010-1234-1234");


        var text = objectMapper.writeValueAsString(user1);
        System.out.println(text);

        //text ->object
        //object mapper 는 default 생성자를 필요
        // object mapper 사용시 생성자에 get이라는 단어가 들어가면 안된다.
        var objectUser = objectMapper.readValue(text, UserRequset.class);

        System.out.println("------------------------");
        System.out.println(objectUser);

    }

}
