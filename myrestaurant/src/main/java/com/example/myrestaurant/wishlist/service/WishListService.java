package com.example.myrestaurant.wishlist.service;

import com.example.myrestaurant.naver.NaverClient;
import com.example.myrestaurant.naver.dto.SearchImageReq;
import com.example.myrestaurant.naver.dto.SearchLocalReq;
import com.example.myrestaurant.wishlist.dto.WishListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;

    public WishListDto search(String query) {

        //지역 검색
        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);

        var searchLocalRes = naverClient.searchLocal(searchLocalReq);
        if (searchLocalRes.getTotal() > 0) {
            // 첫번쩨 아이템 꺼내기
            var localItem = searchLocalRes.getItems().stream().findFirst().get();
            // 정규식 사용해서 문자만 나오게 정리
            var imageQuery = localItem.getTitle().replaceAll("<[^>]*>", "");

            var searchImageReq = new SearchImageReq();

            searchImageReq.setQuery(imageQuery);
            //이미지 검색
            var searchImageRes = naverClient.searchImage(searchImageReq);

            if (searchImageRes.getTotal() > 0) {
                var imageItem = searchImageRes.getItems().stream().findFirst().get();

                // 값이 존재한다면 결과를 리턴
                var result = new WishListDto();
                result.setTitle(localItem.getTitle());
                result.setCategory(localItem.getCategory());
                result.setAddress(localItem.getAddress());
                result.setRoadAddress(localItem.getRoadAddress());
                result.setHomePageLink(localItem.getLink());
                result.setImageLink(imageItem.getLink());

                return result;
            }

        }

        return new WishListDto();
    }


}
