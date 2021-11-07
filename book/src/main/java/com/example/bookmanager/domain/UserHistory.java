package com.example.bookmanager.domain;

import com.example.bookmanager.domain.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Transactional
//@EntityListeners(value = AuditingEntityListener.class)
public class UserHistory extends BaseEntity {
    //extends BaseEntity
    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String name;

    private String email;


//    @CreatedDate
//    private LocalDateTime createAt;
//
//    @LastModifiedDate
//    private LocalDateTime updateAt;


}
