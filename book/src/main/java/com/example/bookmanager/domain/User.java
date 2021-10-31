package com.example.bookmanager.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String email;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
