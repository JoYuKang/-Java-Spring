package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Book;
import com.example.bookmanager.domain.Publisher;
import com.example.bookmanager.domain.Review;
import com.example.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Table;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    @Test
    void Persist(){
        Book book = new Book();

        book.setName("트렌드 코리아 2021");
        book.setAuthorId(1L);
        //book.setPublisherId(1L);
        bookRepository.save(book);
        bookRepository.findAll().forEach(System.out::println);
    }
    @Test
    @Transactional
    void bookRelationTest(){
        givenBookAndReview();
        User user = userRepository.findByEmail("ykang9533@naver.com");
        System.out.println("user의 리뷰 모아보기 " + user.getReviews());
        // 첫번째 리뷰의 책 정보를 가져오기
        System.out.println("book: "+user.getReviews().get(0).getBook());

        System.out.println("Publisher: "+user.getReviews().get(0).getBook().getPublisher());
    }

    private void givenBookAndReview(){
        givenReview(givenUser(),givenBook(givenPublisher()));
    }

    private Publisher givenPublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("시대고사");
        return  publisherRepository.save(publisher);
    }

    private Book givenBook(Publisher publisher){
        Book book = new Book();
        book.setName("JPA 공부");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }

    private User givenUser(){
        return userRepository.findByEmail("ykang9533@naver.com");
    }

    private void givenReview(User user,Book book){
        Review review = new Review();
        review.setTitle("ssafy");
        review.setContent("싸피 합격 가자!");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }
}