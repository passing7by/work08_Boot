package com.web.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		//User 생성
		/*
		User newUser = new User();
		newUser.setName("name02");
		newUser.setPassword("pass02");
		
		userRepository.save(newUser);
		*/
		
		//모든 User 검색
//		userRepository.findAll().forEach(u->System.out.println(u));
		
		/*
		모든 User 검색 
        > 모든 User 정보와 함께 User들이 구입한 Product  정보도 검색 
        >  특정 User 검색 
        >  특정 User 검색과 함께 User가 구입한 Product 정보고 검색 
		*/
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Workshop03Application.class, args);
	}


}
