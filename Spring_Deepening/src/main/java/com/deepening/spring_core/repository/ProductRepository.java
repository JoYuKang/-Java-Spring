package com.deepening.spring_core.repository;

import com.deepening.spring_core.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}