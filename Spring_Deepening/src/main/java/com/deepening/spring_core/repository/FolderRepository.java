package com.deepening.spring_core.repository;

import com.deepening.spring_core.model.Folder;
import com.deepening.spring_core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    List<Folder> findAllByUser(User user);
    List<Folder> findAllByUserAndNameIn(User user, List<String> nameList);
    Folder findByName(String name);
}