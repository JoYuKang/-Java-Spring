package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Book;
import com.example.bookmanager.domain.BookReviewInfo;
import com.example.bookmanager.domain.Review;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewInfoRepositoryTest {
    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void CRUDTest() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBook(givenBook());

        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(10);

        bookReviewInfoRepository.save(bookReviewInfo);

        bookReviewInfoRepository.findAll().forEach(System.out::println);
    }

    @Test
    void CRUDTest2() {

        givenBookReviewInfo();

        bookReviewInfoRepository.findAll().forEach(System.out::println);
        Book result = bookReviewInfoRepository.findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBook();

        System.out.println(result);
        BookReviewInfo result2 = bookRepository
                .findById(7L)
                .orElseThrow(RuntimeException::new)
                .getBookReviewInfo();
        System.out.println(result2);
    }

    private Book givenBook() {
        Book book = new Book();

        book.setName("자바의 신");
        book.setAuthorId(1L);
        //book.setPublisherId(1L);

        bookRepository.save(book);
        return bookRepository.save(book);
    }

    private void givenBookReviewInfo() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();

        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(10);

        bookReviewInfoRepository.save(bookReviewInfo);
    }

    @Test
    @DisplayName("리뷰 확인 테스트")
    @Transactional
    void reviewTest() {
//        List<Review> reviews = reviewRepository.findAll();
//        List<Review> reviews = reviewRepository.findAllByFetchJoin();
        //List<Review> reviews = reviewRepository.findAllByEntityGraph();
        List<Review> reviewList = reviewRepository.findAll();
//        System.out.println(reviews);

        System.out.println("전체 가져오기");

        //reviewRepository.findAll().forEach(System.out::println);
        //reviews.forEach(System.out::println);

        reviewList.forEach(System.out::println);
    }

}