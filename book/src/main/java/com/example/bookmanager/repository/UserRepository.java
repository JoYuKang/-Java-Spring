package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//          Entity, pk
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByName(String name);
    // List<User> findByAddressesIsNotEmpty();
    List<User> findTopByNameOrderByIdDesc(String name);
    Page<User> findByName(String name, Pageable pageable);

    @Query(value = "select * from user limit 1;",nativeQuery = true)
    Map<String, Object> findRowRecord();


    User findByEmail(String email);
}
