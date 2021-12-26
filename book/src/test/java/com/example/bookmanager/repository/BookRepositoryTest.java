package com.example.bookmanager.repository;

import com.example.bookmanager.domain.*;
import com.example.bookmanager.service.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.Table;
import javax.transaction.Transactional;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.ArrayList;

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

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    @DisplayName("확인")
    void bookRemoveCascadeTest() {

        bookRepository.deleteById(1L);
        System.out.println("books: " + bookRepository.findAll());
        System.out.println("publisher: " + publisherRepository.findAll());

        bookRepository.findAll().forEach(book -> System.out.println(book.getPublisher()));
    }

    @Test
    void Persist() {
        Book book = new Book();

        book.setName("트렌드 코리아 2021");
        book.setAuthorId(1L);
        //book.setPublisherId(1L);
        bookRepository.save(book);
        bookRepository.findAll().forEach(System.out::println);
    }

    @Test
    @Transactional
    void bookRelationTest() {
        givenBookAndReview();
        User user = userRepository.findByEmail("ykang9533@naver.com");
        System.out.println("user의 리뷰 모아보기 " + user.getReviews());
        // 첫번째 리뷰의 책 정보를 가져오기
        System.out.println("book: " + user.getReviews().get(0).getBook());

        System.out.println("Publisher: " + user.getReviews().get(0).getBook().getPublisher());
    }


    private void givenBookAndReview() {
        givenReview(givenUser(), givenBook(givenPublisher()));
    }

    private Publisher givenPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("시대고사");
        return publisherRepository.save(publisher);
    }

    private Book givenBook(Publisher publisher) {
        Book book = new Book();
        book.setName("JPA 공부");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }

    private User givenUser() {
        return userRepository.findByEmail("ykang9533@naver.com");
    }

    private void givenReview(User user, Book book) {
        Review review = new Review();
        review.setTitle("ssafy");
        review.setContent("싸피 합격 가자!");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }


    @Test
    @DisplayName("publisher 저장 확인")
    void publisherTest() {
        Book book1 = new Book();
        book1.setName("자바의 신");

        Publisher publisher = new Publisher();
        publisher.setName("확인");
        publisherRepository.save(publisher);

        book1.setPublisher(publisher);
        bookRepository.save(book1);

        System.out.println(publisherRepository.findAll());
        System.out.println(bookRepository.findAll());

    }


    @Test
    @DisplayName("book test")
    void bookTest() {
        Author author = new Author();
        author.setName("하일권");
        authorRepository.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("투썸");

        publisherRepository.save(publisher);

        Book book1 = new Book();
        book1.setName("자바의 신");
        book1.setPublisher(publisher);
        book1.setAuthorId(authorRepository.findByName("하일권").getId());
        bookRepository.save(book1);
        System.out.println("하일권 작가 ID 찾기 : " + bookRepository.findById(1L).get().getAuthorId());

        System.out.println("하일권 작가 찾기 : " + authorRepository.findById(bookRepository.findById(1L).get().getAuthorId()));

        Book book2 = new Book();
        book2.setName("토비의 Spring");
        book2.setPublisher(publisher);

        Book book3 = new Book();
        book3.setName("이펙티브 자바");
        book3.setPublisher(publisher);

        bookRepository.save(book2);
        bookRepository.save(book3);

        Book book4 = bookRepository.findById(1L).get();
        book4.setPublisher(null);
        bookRepository.save(book4);

        System.out.println("book : " + bookRepository.findAll());

        System.out.println("author : " + authorRepository.findAll());

        System.out.println("book4 : " + bookRepository.findById(1L).get().getPublisher());
    }

    @Test
    @DisplayName("deleted false 찾기")
    void deletedFalse() {
        Book book1 = new Book();
        book1.setName("자바의 신");
        book1.setDeleted(false);

        Publisher publisher = new Publisher();
        publisher.setName("투썸");

        publisherRepository.save(publisher);

        Book book2 = new Book();
        book2.setName("토비의 Spring");
        book2.setPublisher(publisher);
        book2.setDeleted(false);

        Book book3 = new Book();
        book3.setName("이펙티브 자바");
        book3.setPublisher(publisher);
        book3.setDeleted(true);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.findAll().forEach(System.out::println);
        bookRepository.findAllCustom().forEach(System.out::println);
        // bookRepository.findAll().forEach(System.out::println);
        //System.out.println(bookRepository.findAll());

        //System.out.println(bookRepository.findById(3L));
    }

    @Test
    @DisplayName("NativeQuery")
    void nativeQueryTest() {
        bookRepository.findAll().forEach(System.out::println);
        bookRepository.findAllCustom().forEach(System.out::println);
    }

    @Test
    @DisplayName("쿼리문")
    void queryTest() {
        Book book1 = new Book();
        book1.setName("자바의 신");
        book1.setDeleted(false);

        Publisher publisher = new Publisher();
        publisher.setName("투썸");

        publisherRepository.save(publisher);

        Book book2 = new Book();
        book2.setName("토비의 Spring");
        book2.setPublisher(publisher);
        book2.setDeleted(false);

        Book book3 = new Book();
        book3.setName("이펙티브 자바");
        book3.setPublisher(publisher);
        book3.setDeleted(true);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        bookRepository.findAll().forEach(System.out::println);

//        bookRepository.findByCategoryIsNullAndNameEqualsAndCreateAtGreaterThanEqualAndUpdateAtGreaterThanEqual(
//                "토비의 Spring", LocalDateTime.now().minusDays(1L),LocalDateTime.now().minusDays(1L)
//        );
        System.out.println("findByNameRecently : " + bookRepository.findByNameRecently(
                "토비의 Spring", LocalDateTime.now().minusDays(1L), LocalDateTime.now().minusDays(1L)));

//        System.out.println("findBookNameAndCategory : " + bookRepository.findBookNameAndCategory());

        System.out.println("findBookNameAndCategory + interface");
        bookRepository.findBookNameAndCategory().forEach(b -> System.out.println(b.getName() +
                " : " + b.getCategory()));

        System.out.println("findBookNameAndCategory + class");
        bookRepository.findBookNameAndCategory2().forEach(b -> System.out.println(b.getName() +
                " : " + b.getCategory()));

        System.out.println("findBookNameAndCategory + Page");
        bookRepository.findBookNameAndCategory2(PageRequest.of(1, 1)).forEach(bookNameAndCategory2 ->
                System.out.println(bookNameAndCategory2.getName() + " : " + bookNameAndCategory2.getCategory()));

        System.out.println("findBookNameAndCategory + Page");
        bookRepository.findBookNameAndCategory2(PageRequest.of(0, 1)).forEach(bookNameAndCategory2 ->
                System.out.println(bookNameAndCategory2.getName() + " : " + bookNameAndCategory2.getCategory()));
    }

}