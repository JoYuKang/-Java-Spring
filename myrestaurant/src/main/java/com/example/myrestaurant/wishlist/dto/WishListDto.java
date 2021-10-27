package com.example.myrestaurant.wishlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishListDto {

    private int index;
    private String title;               // 음식점 이름
    private String category;            // 카테고리
    private String address;             // 주소
    private String roadAddress;         // 도로명
    private String homePageLink;        // 홈페이지
    private String imageLink;           // 이미지주소
    private boolean isVisit;            // 방문 확인
    private int visitCount;             // 방문 횟수
    private LocalDateTime lastVisitDate;// 마지막 방문 시간

}
