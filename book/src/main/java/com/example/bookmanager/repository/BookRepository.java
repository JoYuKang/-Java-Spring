package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Book;
import com.example.bookmanager.repository.dto.BookNameAndCategory;
import com.example.bookmanager.repository.dto.BookNameAndCategory2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByName(String name);

    @Modifying
    @Query(value = "update book set category='none'", nativeQuery = true)
    void update();


    // 이렇게 실제로 사용 x
//    List<Book> findByCategoryIsNullAndNameEqualsAndCreateAtGreaterThanEqualAndUpdateAtGreaterThanEqual
//            (String name, LocalDateTime createdAt, LocalDateTime updatedAt);

    // 숫자를 넣어 변수의 순서대로 값이 입력된다. (실제로는 별로 사용 x)
    //    @Query(value = "select b from Book b "+
//    "where name = ?1 and createdAt >= ?2 and updatedAt >= ?3 and category is null")
//    List<Book> findByNameRecently(String name,LocalDateTime createdAt,LocalDateTime updatedAt);

    // Param을 사용하여 쿼리를 Mapping 해준다.
    @Query(value = "select b from Book b " +
            "where name = :name and createdAt >= :createdAt and updatedAt >= :updatedAt and category is null")
    List<Book> findByNameRecently(
            @Param("name") String name,
            @Param("createdAt") LocalDateTime createdAt,
            @Param("updatedAt") LocalDateTime updatedAt);

    @Query(value = "select b.name as name, b.category as category from Book b ")
    List<BookNameAndCategory> findBookNameAndCategory();

    @Query(value = "select new com.example.bookmanager.repository.dto.BookNameAndCategory2(b.name,b.category) from Book b")
    List<BookNameAndCategory2> findBookNameAndCategory2();

    @Query(value = "select new com.example.bookmanager.repository.dto.BookNameAndCategory2(b.name,b.category) from Book b")
    Page<BookNameAndCategory2> findBookNameAndCategory2(Pageable pageable);
}
