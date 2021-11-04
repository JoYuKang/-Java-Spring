package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserHistoryRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
    void userHistoryTest(){
        User user = new User();
        //user.setId(6L);
        user.setEmail("yu-kang@naver.com");
        user.setName("yu--kang");

        userRepository.save(user);

        user.setName("zang---go----la---ni");
        userRepository.save(user);
        userHistoryRepository.findAll().forEach(System.out::println);

    }
}