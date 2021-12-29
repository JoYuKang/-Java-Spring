package com.example.bookmanager.service;

import com.example.bookmanager.domain.Comment;
import com.example.bookmanager.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public void init() {
        for (int i = 0; i < 10; i++) {
            Comment comment = new Comment();
            comment.setComment("comment 별점: " + i);

            commentRepository.save(comment);
        }
    }

    @Transactional(readOnly = true)
    public void update() {
        List<Comment> comments = commentRepository.findAll();

        for (int i = 0; i < comments.size(); i++) {
            comments.get(i).setComment("----Comment 수정 중----");
        }
       // commentRepository.saveAll(comments);
    }
    @Transactional
    public void insert(){
        Comment comment = commentRepository.findById(2L).get();
        comment.setComment("이것도 추가");
        commentRepository.save(comment);
    }


}
