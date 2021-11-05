package com.example.bookmanager.domain;

import com.example.bookmanager.domain.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
//@EntityListeners(value = AuditingEntityListener.class)
public class Book extends BaseEntity implements Auditable {
//extends BaseEntity implements Auditable
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String author;

    @Override
    public LocalDateTime getCreateAt() {
        return null;
    }

    @Override
    public LocalDateTime getUpdateAt() {
        return null;
    }

    @Override
    public void setCreateAt(LocalDateTime createAt) {

    }

    @Override
    public void setUpdateAt(LocalDateTime updateAt) {

    }

//    @CreatedDate
//    private LocalDateTime createAt;
//
//    @LastModifiedDate
//    private LocalDateTime updateAt ;
//
//    @PrePersist
//    public void prePersist(){
//        this.createAt = LocalDateTime.now();
//        this.updateAt = LocalDateTime.now();
//    }
//    @PreUpdate
//    public void PreUpdate(){
//        this.updateAt = LocalDateTime.now();
//    }

}
