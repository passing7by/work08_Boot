package com.web.spring;

import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.entity.User;
import com.web.spring.repository.UserRepository;

@SpringBootApplication
public class Workshop02Application implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		//1. 저장
		/*
		User newUser0 = new User("ggg", "지연", "333");
		userRepository.save(newUser0);

		User newUser1 = new User("user04", "유저4", "pass04");
		userRepository.save(newUser1);
		
		User newUser2 = new User("user05", "유저5", "pass05");
		userRepository.save(newUser2);
		
		User newUser3 = new User("user03", "유저6", "pass06");
		userRepository.save(newUser3);
		*/
		
		//2. 검색
		//아이디로 검색
		/*
		Optional<User> user = userRepository.findById("user01");
		System.out.println(user);
		
		//모두 검색
		userRepository.findAll().forEach(i->System.out.println(i));
		*/
		
		//추가
//		userRepository.findByIdContainingOrderById("user").forEach(i->System.out.println(i));
//		userRepository.findByIdContainingOrderById("USER").forEach(i->System.out.println(i));
//		userRepository.findByIdNotContainingOrderById("USER").forEach(i->System.out.println(i));
//		userRepository.findByIdNotInOrderById(List.of("user02", "user03")).forEach(i->System.out.println(i));
		
		//3. 수정
		/*
		User updateUser = userRepository.findById("user01").orElseThrow();
		updateUser.setPassword("1111");
		*/
		
		//4. 삭제
		/*
		User deleteUser = userRepository.findById("user01").orElseThrow();
		userRepository.delete(deleteUser);
		*/
		
		
		
	}
	
	@Transactional
	public static void main(String[] args) {
		SpringApplication.run(Workshop02Application.class, args);
	}

}
