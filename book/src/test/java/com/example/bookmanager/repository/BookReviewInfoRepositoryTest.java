package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Book;
import com.example.bookmanager.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookReviewInfoRepositoryTest {
    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;

    @Autowired
    private BookRepository bookRepository;


    @Test
    void CRUDTest(){
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        //bookReviewInfo.setBook();
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(10);

        bookReviewInfoRepository.save(bookReviewInfo);

        bookReviewInfoRepository.findAll().forEach(System.out::println);
    }

    @Test
    void CRUDTest2(){

        givenBookReviewInfo();

        bookReviewInfoRepository.findAll().forEach(System.out::println);
        Book result = bookReviewInfoRepository.findById(1L)
                        .orElseThrow(RuntimeException::new)
                        .getBook();

        System.out.println(result);
        BookReviewInfo result2 = bookRepository
                .findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBookReviewInfo();

    }

    private Book givenBook(){
        Book book = new Book();

        book.setName("자바의 신");
        book.setAuthorId(1L);
        book.setPublisherId(1L);

        bookRepository.save(book);
        return bookRepository.save(book);
    }
    private void givenBookReviewInfo(){
        BookReviewInfo bookReviewInfo = new BookReviewInfo();

        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(10);

        bookReviewInfoRepository.save(bookReviewInfo);
    }
}