package com.deepening.spring_core.repository;

import com.deepening.spring_core.model.User;
import com.deepening.spring_core.model.UserTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTimeRepository extends JpaRepository<UserTime, Long> {
    UserTime findByUser(User user);
}