package com.example.bookmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String city; //시 enum 타입을 설정하면 더 정제된 데이터로 나중에 대이터를 찾기 편하다.?

    private String district; // 구

    @Column(name = "address_detail")
    private String detail;  //상세주소

    private String zipCode; //우편번호


}
