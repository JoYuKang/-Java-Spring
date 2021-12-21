package com.example.bookmanager.service;

import com.example.bookmanager.domain.Book;
import com.example.bookmanager.domain.Publisher;
import com.example.bookmanager.repository.AuthorRepository;
import com.example.bookmanager.repository.BookRepository;
import com.example.bookmanager.repository.PublisherRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PublisherRepository publisherRepository;


    @Test
    @DisplayName("book & author test")
    void test() {
        try {
            bookService.putBookAndAuthor();
        } catch (Exception e) {
            System.out.println(">>> " + e.getMessage());
        }

        System.out.println("book : " + bookRepository.findAll());

        System.out.println("author : " + authorRepository.findAll());
    }

    @Test
    @DisplayName("isolationtest")
    void isolationtest() {
        Book book = new Book();
        book.setName("JPA 강의");
        bookRepository.save(book);
        System.out.println(">>>>>>>>>>>>> " + bookRepository.findByName("JPA 강의").getId());
        //bookService.get(bookRepository.findByName("JPA 강의"));
        bookService.get(bookRepository.findByName("JPA 강의").getId());

        System.out.println(">>> " + bookRepository.findAll());

    }


    @Test
    //@Transactional
    @DisplayName("BookCascadeTest")
    void bookCascadeTest() {
        Book book = new Book();
        book.setName("JPA CascadeTest");
//        bookRepository.save(book);

        Publisher publisher = new Publisher();
        publisher.setName("교보문고");

//        publisherRepository.save(publisher);

        book.setPublisher(publisher);
        bookRepository.save(book);

        //publisher.getBooks().add(book);
        publisher.addBook(book); // 가독성을 위해 수정 메소드 추가
//        publisherRepository.save(publisher);
//        (cascade = CascadeType.PERSIST) 추가되어 위에 부분이 없어도 작동한다.

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publisher : " + publisherRepository.findAll());

        Book book1 = bookRepository.findById(1L).get();
        book1.getPublisher().setName("YES24");
        bookRepository.save(book1);
        System.out.println("publisher : " + publisherRepository.findAll());
    }
}