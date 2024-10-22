package com.web.spring;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.entity.Product;
import com.web.spring.entity.User;
import com.web.spring.repository.ProductRepository;
import com.web.spring.repository.UserRepository;

@SpringBootApplication
public class Workshop03Application implements CommandLineRunner{ //CommandLineRunner 상속
	
	//repository autowired 추가
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//product, user 생성
		/*
		Product product1 = new Product();
		product1.setMaker("LG");
		product1.setModel("스탠바이미");
		product1.setRegDate(LocalDateTime.now());
		Product product2 = new Product();
		product2.setMaker("Apple");
		product2.setModel("MacBook Pro");
		product2.setRegDate(LocalDateTime.now());
		Product product3 = new Product();
		product3.setMaker("Samsung");
		product3.setModel("갤럭시 S24");
		product3.setRegDate(LocalDateTime.now());
		Product product4 = new Product();
		product4.setMaker("Samsung");
		product4.setModel("갤럭시 탭 S9");
		product4.setRegDate(LocalDateTime.now());
		
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		productRepository.save(product4);
		
		User newUser1 = new User();
		newUser1.setName("jinam123");
		newUser1.setPassword("123");
		User newUser2 = new User();
		newUser2.setName("name01");
		newUser2.setPassword("pass01");
		User newUser3 = new User();
		newUser3.setName("name02");
		newUser3.setPassword("pass02");
		User newUser4 = new User();
		newUser4.setName("name03");
		newUser4.setPassword("pass03");
		
		newUser1.setProducts(List.of(product1));
		newUser2.setProducts(List.of(product2));
		newUser3.setProducts(List.of(product3, product4));
		
		userRepository.save(newUser1);
		userRepository.save(newUser2);
		userRepository.save(newUser3);
		userRepository.save(newUser4);
		*/
	
		//모든 User 검색
//		userRepository.findAll().forEach(u->System.out.println(u));
		
		//모든 User 정보와 함께 User들이 구입한 Product 정보도 검색
		/*
		userRepository.findAll().forEach(u->{
			System.out.println("------------------------------------------");
			System.out.println(u);
			System.out.println(u.getProducts());
			System.out.println("------------------------------------------");			
		});
		*/
		
		//특정 User 검색
		Optional<User> user = userRepository.findById(3L);
		System.out.println(user);
		
		//특정 User 검색과 함께 User가 구입한 Product 정보도 검색
		System.out.println(user.get().getProducts());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Workshop03Application.class, args);
	}


}
