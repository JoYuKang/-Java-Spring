package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//          Entity, pk
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByName(String name);
    List<User> findByAddressesIsNotEmpty();
    List<User> findTopByNameOrderByIdDesc(String name);
}
