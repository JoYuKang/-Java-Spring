package com.deepening.spring_core.repository;

import com.deepening.spring_core.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByUserId(Long userId, Pageable pageable);
}