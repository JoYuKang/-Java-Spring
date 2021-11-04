package com.example.bookmanager.domain.listener;

import jdk.vm.ci.meta.Local;

import java.time.LocalDateTime;

public interface Auditable {
    LocalDateTime getCreateAt();
    LocalDateTime getUpdateAt();

    void setCreateAt(LocalDateTime createAt);

    void setUpdateAt(LocalDateTime updateAt);
}
