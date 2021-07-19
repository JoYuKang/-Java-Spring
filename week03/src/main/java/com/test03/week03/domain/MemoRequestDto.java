package com.test03.week03.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemoRequestDto {

    private final String username;
    private final String contents;


}
