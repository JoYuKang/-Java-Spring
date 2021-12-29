package com.example.bookmanager.service;

import com.example.bookmanager.repository.CommentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;


    @Test
    @DisplayName("commentService 확인")
    void commentTest() {
        commentService.init();
        commentService.update();
        commentService.insert();
        commentRepository.findAll().forEach(System.out::println);
    }


}