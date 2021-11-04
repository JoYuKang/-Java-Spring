package com.example.bookmanager.repository;

import com.example.bookmanager.domain.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;

public interface UserHistoryRepository extends JpaRepository<UserHistory, LinkOption> {
}
