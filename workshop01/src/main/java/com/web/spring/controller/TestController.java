package com.web.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.dto.Product;


@RestController
public class TestController {
	
	// http://localhost:9999/product?no=1234
	@GetMapping("/product")
	public ResponseEntity<?> getProduct1(@RequestParam int no) {
		Product rvo = new Product(1234, "연필", 500, "잘 써져요");
		return ResponseEntity
				.status(200)
				.body(rvo.toString());
	}
	
	// http://localhost:9999/product/1234
	@GetMapping("/product/{no}")
	public ResponseEntity<?> getProduct2(@PathVariable int no) { 
		Product rvo = new Product(1234, "연필", 500, "잘 써져요");
		return ResponseEntity
				.status(200)
				.body(rvo.toString());
	}
	
	// http://localhost:9999/products
	@GetMapping("/products")
	public ResponseEntity<?> getProducts() { 
		Product rvo1 = new Product(1234, "연필", 500, "잘 써져요");
		Product rvo2 = new Product(1111, "볼펜", 1000, "잘 써져요");
		Product rvo3 = new Product(2222, "지우개", 200, "잘 지워져요");
		Product rvo4 = new Product(3333, "화일", 2000, "하늘색 화일입니다");
		List<Product> list = new ArrayList<>();
		list.add(rvo1);
		list.add(rvo2);
		list.add(rvo3);
		list.add(rvo4);
		return ResponseEntity
				.status(200)
				.body(list.toString());
	}
	
	// http://localhost:9999/product
	@PostMapping("/product")
	public ResponseEntity<?> insertproduct(@RequestBody Product pvo) {
		return ResponseEntity
				.status(201)
				.body("[등록 완료] product no : " + pvo.getNo());
	}
	
	// http://localhost:9999/product
	@PutMapping("/product")
	public ResponseEntity<?> updateMember(@RequestBody Product pvo){
		return ResponseEntity
				.status(202)
				.body("[수정 완료] product no : " + pvo.getNo());
	}
	
	// http://localhost:9999/product/5555
	@DeleteMapping("/product/{no}")
	public ResponseEntity<?> delete(@PathVariable String no) {
		return ResponseEntity
				.status(200)
				.body("[삭제 완료] product no : " + no);
	}
}
	
