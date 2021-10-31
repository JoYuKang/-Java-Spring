package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
                                        //          Entity, pk
public interface UserRepository extends JpaRepository<User,Long> {

}
