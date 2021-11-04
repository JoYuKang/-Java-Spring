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
//@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@EntityListeners(value = AuditingEntityListener.class)
public class Book  implements Auditable {
//extends BaseEntity
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String author;

    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime updateAt ;

    @PrePersist
    public void prePersist(){
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }
    @PreUpdate
    public void PreUpdate(){
        this.updateAt = LocalDateTime.now();
    }

}
