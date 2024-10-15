package com.web.spring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.entity.Member;
import com.web.spring.repository.BoardRepository;
import com.web.spring.repository.MemberRepository;
import com.web.spring.service.MemberService;

@SpringBootApplication
public class Boot08JpaServiceApplication implements CommandLineRunner{

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberService memberservice;
	@Autowired
	BoardRepository boardRepository;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
//		//1. Builer 패턴으로 Member생성
		
//		Member m = Member.builder()
//				.id("kosta")
//				.pwd("1234")
//				.address("종각")
//				.name("홍종각")
//				.regDate(LocalDateTime.now())
//				.build();
//		Member m2 = Member.builder()
//				.id("kim")
//				.pwd("1234")
//				.address("종각")
//				.name("김종각")
//				.regDate(LocalDateTime.now())
//				.build();
		
//		memberRepository.save(m);
//		memberRepository.save(m2);
		
		//2.아이디가 홍인 사람 검색
		
//		Member findM = memberRepository.duplicateCheck("kim");
//		
//		System.out.println("아이디 kim"+findM);
//		
//		Member loginM = memberRepository.login(m);
//		
//		System.out.println("아이디 kosta pwd 1234"+loginM);
		
		//4.
		//memberservice.signUP(m);
		
		//5. 모든 게시물 검색 ... 이때 작성자 정보도 함께 검색
//		boardRepository.boardList().forEach(b->{
//			System.out.println(b);
//			System.out.println(b.getMember());
//			System.out.println("============================");
//		});
//		boardRepository.findAll().forEach(b->{
//			System.out.println(b);
//			System.out.println(b.getMember());
//			System.out.println("============================");
//		});
		//특정한 작성자가 쓴 게시물 검색
		boardRepository.getBoard("kim").forEach(b->{
			System.out.println(b);
			System.out.println(b.getMember());
			System.out.println("============================");
		});
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Boot08JpaServiceApplication.class, args);
	}

	

}
