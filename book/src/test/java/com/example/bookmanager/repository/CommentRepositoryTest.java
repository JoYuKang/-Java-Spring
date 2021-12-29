package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    @DisplayName("comment 테스트")
    void commentTest(){
        Comment comment = new Comment();
        comment.setComment("별로");
        comment.setCommentedAt(LocalDateTime.now());

        commentRepository.save(comment);

        entityManager.clear();

        System.out.println(commentRepository.findById(1L));

        System.out.println(commentRepository.findAll());


    }


}