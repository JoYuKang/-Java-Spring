package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Table;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void Persist(){
        Book book = new Book();

        book.setName("트렌드 코리아 2021");
        book.setAuthor("김난도");
        bookRepository.save(book);
        bookRepository.findAll().forEach(System.out::println);
    }

}