package com.deepening.spring_core.service;

import com.deepening.spring_core.model.Product;
import com.deepening.spring_core.dto.ProductMypriceRequestDto;
import com.deepening.spring_core.dto.ProductRequestDto;
import com.deepening.spring_core.repository.ProductRepository;
import org.springframework.stereotype.Service;
// org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
public class ProductService {
    // 멤버 변수 선언
    private final ProductRepository productRepository;

    // 생성자: ProductService() 가 생성될 때 호출됨
    //@Autowired

    public ProductService(ProductRepository productRepository) {
        // 멤버 변수 생성
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() throws SQLException {
        // 멤버 변수 사용
        return productRepository.findAll();
    }

    // 회원 ID 로 등록된 모든 상품 조회
    public List<Product> getProducts(Long userId) throws SQLException {
        return productRepository.findAllByUserId(userId);
    }

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Product createProduct(ProductRequestDto requestDto, Long userId ) {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto, userId);
        productRepository.save(product);
        return product;
    }
    @Transactional
    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) throws SQLException {
        Product product = productRepository.findById(id).orElseThrow( ()->
                new IllegalAccessError("해당 아이디가 없습니다."));

        int myPrice = requestDto.getMyprice();
        //productRepository.updateProductMyPrice(id, myPrice); 바꾸는법
        // 방법 1
        //product.setMyprice(myPrice);
        //productRepository.save(product);
        // 방법 2
        // @Transactional 추가

        product.updateMyprice(myPrice);


        return product;
    }
    // 모든 상품 조회 (관리자용)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
//    public List<Product> getProducts() throws SQLException {
//        ProductRepository productRepository = new ProductRepository();
//        return productRepository.getProducts();
//    }
//
//    public Product createProduct(ProductRequestDto requestDto) throws SQLException {
//        ProductRepository productRepository = new ProductRepository();
//        // 요청받은 DTO 로 DB에 저장할 객체 만들기
//        Product product = new Product(requestDto);
//        productRepository.createProduct(product);
//        return product;
//    }
//
//    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) throws SQLException {
//        if(requestDto.getMyprice()<0){
//            throw new IllegalAccessError("희망 최저가는 0이하가 될 수 없습니다.");
//        }
//        ProductRepository productRepository = new ProductRepository();
//        Product product = productRepository.getProduct(id);
//        if (product == null) {
//            throw new NullPointerException("해당 아이디가 존재하지 않습니다.");
//        }
//
//        int myPrice = requestDto.getMyprice();
//        productRepository.updateProductMyPrice(id, myPrice);
//        return product;
//    }