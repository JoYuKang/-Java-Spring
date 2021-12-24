package com.example.bookmanager.domain;


import com.example.bookmanager.domain.listener.Auditable;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public class BaseEntity implements Auditable {

    @CreatedDate    // columnDefinition은 sql에 바로 들어가서 defalut now()만을 써주면 datetime이 삭제 된다.
                    // ex) columnDefinition = default null, nullable = false -> default null not null 이렇게 나와서 충돌함
    @Column(nullable = false,updatable = false , columnDefinition = "datetime(6) default now(6)")
    private LocalDateTime createdAt;                            // datetime(6) 과 now(6) 자리수도 맞춰야지 오류 발생 x

    @LastModifiedDate
    @Column(nullable = false, columnDefinition = "datetime(6) default now(6)")
    private LocalDateTime updatedAt;

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
}
