package com.example.filter.dto;

import lombok.*;



@Data // @Getter + @Setter + toString()
@NoArgsConstructor // 기본생성자 생성
@AllArgsConstructor // 전체 데이터를 받는 생성자
public class User {
    private String name;
    private int age;
}
