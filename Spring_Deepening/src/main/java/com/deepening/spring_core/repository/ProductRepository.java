package com.deepening.spring_core.repository;

import com.deepening.spring_core.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByUserId(Long userId);
    
    // 상품명이 title인 관심상품 1개 조회
    Product findByTitle(String title);

    // 상품명이 word가 포함된 모든 상품 조회
    List<Product> findAllByTitleContaining(String word);

    // 최저가가 fromPrice ~ toPrice인 모든 상품 조회
    List<Product> findByLpriceBetween(int fromprice, int toprice);
}