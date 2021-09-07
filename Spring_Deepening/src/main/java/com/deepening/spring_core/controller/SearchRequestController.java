package com.deepening.spring_core.controller;


import com.deepening.spring_core.model.User;
import com.deepening.spring_core.model.UserTime;
import com.deepening.spring_core.repository.UserTimeRepository;
import com.deepening.spring_core.security.UserDetailsImpl;
import com.deepening.spring_core.util.NaverShopSearch;
import com.deepening.spring_core.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // JSON으로 응답함을 선언합니다.
public class SearchRequestController {

    private final NaverShopSearch naverShopSearch;

    @Autowired
    public SearchRequestController(NaverShopSearch naverShopSearch) {
        this.naverShopSearch = naverShopSearch;
    }

    @GetMapping("/api/search")
    public List<ItemDto> getItems(@RequestParam String query) {
        String resultString = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItems(resultString);
    }
}