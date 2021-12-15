package com.example.bookmanager.service;

import com.example.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("user 영속성 확인 테스트 return ueser 받아서 사용")
    void test1() {
        userRepository.save(userService.put1());

        System.out.println("이메일 확인 : " + userRepository.findByEmail("wodn@naver.com"));
        System.out.println("이름 확인 : " + userRepository.findByName("재우"));
    }

    @Test
    @DisplayName("user 영속성 확인 테스트 entityManager 사용 ")
    void test2() {
        userService.put2();

        System.out.println("이메일 확인 : " + userRepository.findByEmail("wodn@naver.com"));
        System.out.println("이름 확인 : " + userRepository.findByName("재우"));
    }


}