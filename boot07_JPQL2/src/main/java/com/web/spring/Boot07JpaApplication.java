package com.web.spring;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.entity.Board;
import com.web.spring.entity.Custom;
import com.web.spring.entity.Role;
import com.web.spring.repository.BoardRepository;
import com.web.spring.repository.CustomRepository;
import com.web.spring.repository.RoleRepository;



@SpringBootApplication
public class Boot07JpaApplication implements CommandLineRunner{

	@Autowired
	private RoleRepository rolerepository;
	
	@Autowired
	private CustomRepository customrepository;
	
	@Autowired
	private BoardRepository boardrepository;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		////////////// [개인적으로 테스트해 본 내용] ///////////////
		
		////////////////////////////////////////////////////////////
		
		//1. 모든 게시글 검색..findAll
//		boardrepository.findAll().forEach(b->{
//			System.out.println(b.getCustom());
//			
//		});
		
//		boardrepository.getBoards().forEach(b->{
//			System.out.println(b);
//			System.out.println(b.getCustom());
//			
//		});
		
//		Long boardCount = boardrepository.getBoardCount();
//		System.out.println("전체 게시글의 갯수==="+boardCount);
		/*
		//3. admin 권한을 가지는 사람이 작성한 게시글을 다 검색...
		Role r =rolerepository.findById(2).get();
		System.out.println(r);
		
		Custom c = new Custom();
		c.setName("한강");
		c.setEmail("js@gmail.com");
		c.setPassword("7777");
		c.setRegDate(LocalDateTime.now());
		c.setRoles(Set.of(r));//사용자 권한을 주입...Set으로

		customrepository.save(c);
		*/
		/*
		//4.admin 권한을 가지는 12번 사용자가 게시글을 작성
		Custom c= customrepository.findById(12).get();
		Board b = new Board();
		b.setCustom(c);
		b.setTitle("관리자 권한 작성");
		b.setContent("해당 게시판은 관리자가 없습니다.");
		b.setRegDate(LocalDateTime.now());
		boardrepository.save(b);
		*/
		
		//5.
		/*
		boardrepository.getBoards("ROLE_ADMIN")
		.forEach(b->{
			System.out.println(b);
			System.out.println(b.getCustom());
		});
	*/
		/*
		boardrepository.getBoardsNative().forEach(b->{
		System.out.println(b);
		System.out.println(b.getCustom());
		});
	*/
		boardrepository.getBoardsNative2().forEach(b->{
			System.out.println(b.getClass().getName());
			System.out.println("글 내용"+b.getContent());//null떨어짐,query에서 질의를 안함
			System.out.println("글 제목"+b.getTitle());
			System.out.println("보드 아이디"+b.getBoardId());
			System.out.println("보드 이름"+b.getName());
			System.out.println("==================================");
			});
		
		
		//jdk.proxy7.$Proxy152 인터페이스 기반으로 작성된 class 동적으로 생성해주는 자바문법
		
		
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Boot07JpaApplication.class, args);
	}

	

}
