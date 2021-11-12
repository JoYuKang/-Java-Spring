package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Author;
import com.example.bookmanager.domain.Book;
import com.example.bookmanager.domain.BookAndAuthor;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookAndAuthorRepository bookAndAuthorRepository;

    @Transactional
    @Test
    void manyToManyTest() {
        Book book1 = givenBook("자바");
        Book book2 = givenBook("스프링");
        Book book3 = givenBook("리액트");
        Book book4 = givenBook("이펙티브");

        Author author1 = givenAuthor("martin");
        Author author2 = givenAuthor("steve");
        Author author3 = givenAuthor("jesin");

        book1.addAuthor(author1);
        book2.addAuthor(author1, author2);
        book3.addAuthor(author3, author1);
        book4.addAuthor(author1, author2, author3);

        author1.addBook(book1, book2, book3, book4);
        author2.addBook(book2, book4);
        author3.addBook(book3, book4);

        bookRepository.saveAll(Lists.newArrayList(book1, book2, book3, book4));
        authorRepository.saveAll(Lists.newArrayList(author1, author2, author3));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("author through book : " + bookRepository.findAll().get(2).getAuthors());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("books through author : " + authorRepository.findAll().get(2).getBooks());
    }

    @Test
    @Transactional
    void bookAndAuthorTest() {
        Book book1 = givenBook("자바");
        Book book2 = givenBook("스프링");
        Book book3 = givenBook("리액트");
        Book book4 = givenBook("이펙티브");

        Author author1 = givenAuthor("martin");
        Author author2 = givenAuthor("steve");
        Author author3 = givenAuthor("jesin");

        BookAndAuthor bookAndAuthor1 = givenBookAndAuthor(book1, author1);
        BookAndAuthor bookAndAuthor2 = givenBookAndAuthor(book2, author2);
        BookAndAuthor bookAndAuthor3 = givenBookAndAuthor(book3, author1);
        BookAndAuthor bookAndAuthor4 = givenBookAndAuthor(book3, author2);
        BookAndAuthor bookAndAuthor5 = givenBookAndAuthor(book4, author1);
        BookAndAuthor bookAndAuthor6 = givenBookAndAuthor(book4, author3);
        BookAndAuthor bookAndAuthor7 = givenBookAndAuthor(book4, author2);

        book1.addBookAndAuthors(bookAndAuthor1);
        book2.addBookAndAuthors(bookAndAuthor2);
        book3.addBookAndAuthors(bookAndAuthor3, bookAndAuthor4);
        book4.addBookAndAuthors(bookAndAuthor5, bookAndAuthor6, bookAndAuthor7);

        author1.addBookAndAuthors(bookAndAuthor1, bookAndAuthor3, bookAndAuthor5);
        author2.addBookAndAuthors(bookAndAuthor2, bookAndAuthor4, bookAndAuthor7);
        author3.addBookAndAuthors(bookAndAuthor6);

        bookRepository.saveAll(Lists.newArrayList(book1, book2, book3, book4));
        authorRepository.saveAll(Lists.newArrayList(author1, author2, author3));

        bookRepository.findAll().get(2).getBookAndAuthors().forEach(o -> System.out.println(o.getAuthor()));
        authorRepository.findAll().get(0).getBookAndAuthors().forEach(o -> System.out.println(o.getBook()));


    }

    private BookAndAuthor givenBookAndAuthor(Book book, Author author) {
        BookAndAuthor bookAndAuthor = new BookAndAuthor();
        bookAndAuthor.setAuthor(author);
        bookAndAuthor.setBook(book);

        return bookAndAuthorRepository.save(bookAndAuthor);

    }

    private Book givenBook(String name) {
        Book book = new Book();
        book.setName(name);

        return bookRepository.save(book);
    }

    private Author givenAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }


}