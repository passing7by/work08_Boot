package com.web.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	//모든 상품의 갯수
	Long countAllBy();
	
	//조회한 상품 중 2개만 받아오기
	List<Product> findFirst2ByOrderByProNo();
	
}
