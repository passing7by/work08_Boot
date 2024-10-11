package com.web.spring;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.entity.Custom;
import com.web.spring.repository.CustomRepository;

import jakarta.transaction.Transactional;

//CustomRepository를 주입 Spring Data JPa가 생성하는 빈을 여기서 가져다 쓴다
@SpringBootApplication
public class Boot05JPARepositoryApplication implements CommandLineRunner{
	
	//주입된 해당 빈을 사용해서 CRUD 작업 모두 가능
	//트랜잭션 단위로..EntityManager가 내부적으로 모든 일을 처리
	@Autowired
	private CustomRepository customRepository;
	
	@Override
	@Transactional //jpa 메소드가 호출될 때 트랜잭션이 실행되고, 메소드가 종료될 때 트랜잭션이 끝남
	public void run(String... args) throws Exception {
//		Optional<Custom> ot = customRepository.findById(1);
//		System.out.println(ot);
		
//		Custom c = customRepository.findById(1).orElseThrow();
//		System.out.println("1번 고객에 대한 정보 : " + c);
		
		//1. CustomRepository를 실제로 구현하고 있는 구현체를 출력
		/*
		 jdk.proxy7.$Proxy132
		 ::
		 Proxy는 인터페이스를 구현하고 있는 객체를 동적으로 생성해주는 자바 기술
		 모든 자바 프레임워크 구현체들은 Proxy 기술을 이용해서 만들어짐
		 */
//		System.out.println(customRepository.getClass().getName());
		
		//2. 새로운 Custom을 추가
//		Custom c1 = new Custom();
////		c1.setName("제시카");
//		c1.setEmail("jj@google.com");
//		c1.setPassword("8888");
//		c1.setRegDate(LocalDateTime.now());
//		
//		customRepository.save(c1); //
		
		//3. 방금 추가한 사람을 삭제
//		customRepository.deleteById(5); //select 호출된 뒤에 delete가 호출됨 (쿼리문 두 번 돌아감)
		
//		Custom deleteC = customRepository.findById(4).orElseThrow();
//		customRepository.delete(deleteC);
		//이 방법이 더 좋은 방법...왜? -> optional로 핸들링 가능 & 1차 캐시에 데이터가 있는 경우에는 select 호출되지 않음
		
		//4. 수정하기...update 함수는 따로 제공되지 않음 - Entity 정보와 스냅샷 정보가 다를 때 트랜잭션이 완료되는 시점에 이걸 감지하고 update 가 자동으로 호출됨
//		Custom updateC = customRepository.findById(1).orElseThrow();
//		System.out.println("UPdate 하기 전 >> " + updateC); //스냅샷에 저장된 정보
//		
//		updateC.setPassword("0000"); //변경...Entity 정보가 변경
//		System.out.println("UPdate 한 후 >> " + updateC); //트랜잭션이 끝날 때 스냅샷 정보와 Entity 정보 비교 (차이점이 있는지 없는지 감지)	
		
		//findByNameLike
//		customRepository.findByNameLike("홍").forEach(i->System.out.println(i));
		
		//findByNameEndingWith
//		customRepository.findByNameEndingWith("종각").forEach(i->System.out.println(i));
		
//		customRepository.findByOrderByCustomIdDesc().forEach(i->System.out.println(i));
//		
//		customRepository.findByCustomIdGreaterThanOrderByCustomIdDesc(3).forEach(i->System.out.println(i));
		
//		customRepository.findByCustomIdGreaterThanAndNameEndingWith(1, "종각").forEach(i->System.out.println(i));
		
		//findByNameNot
//		customRepository.findByNameNot("김종각")
//						.forEach(i->System.out.println(i));
		
		
//		System.out.println("----------------------------------");
		
		//findByCustomIdIn
//		customRepository.findByCustomIdIn(List.of(1, 3, 5, 6)).forEach(i->System.out.println(i));
	}

	
	public static void main(String[] args) {
		SpringApplication.run(Boot05JPARepositoryApplication.class, args);
	}




}
