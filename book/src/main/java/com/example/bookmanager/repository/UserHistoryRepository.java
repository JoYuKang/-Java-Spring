package com.example.bookmanager.repository;

import com.example.bookmanager.domain.UserHistory;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;
import java.util.List;
public interface UserHistoryRepository extends JpaRepository<UserHistory, LinkOption> {

    List<UserHistory> findByUserId(Long userid);

    List<UserHistory> findByEmail(String s);
}
