package com.web.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.repository.BoardRepository;
import com.web.spring.repository.CustomRepository;
import com.web.spring.repository.RoleRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Boot06JpaEntitiesApplication implements CommandLineRunner{
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CustomRepository customRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		//모든 role 정보를 받아옴
		/*
		roleRepository.findAll()
					  .forEach(c->System.out.println(c));
		*/
		
		//모든 custom 정보를 받아옴
		/*
		customRepository.findAll()
						.forEach(c->System.out.println(c));
		*/
		
		/*
		//findAll --> select * vrom custom; //한번의 쿼리로 전체 Custom을 받아온다
		//c.getRoles() --> select * from custom_folr join role where custom_id=?
		 * 
		 이런 문제상황을 N + 1 문제라고 함
		 만약 Custom 레코드 수가 많다면 심각한 성능 저하가 일어남
		 
		 연관관계가 설정된 엔터티를 조회할 경우, findall, 데이터의 갯수(n)만큼의 조인 select절이 계속적으로 실행됨
		 
		 Custom --> custom_role --> role 여기 안에 있는 데이터를 한번의 쿼리문으로 받아올 수 없을까?
		
		 */
		/*
		customRepository.findAll()
						.forEach(c->{
							System.out.println(c);
							System.out.println(c.getRoles());
						});
		*/
		
		//3. 모든 보드 정보를 받아온다.
		//findAll에서는 보드 정보만 받아오고 싶지만 fetchType이 EAGER로 잡혀져 있어서 함께 나옴...LAZY로 변경
		/*
		boardRepository.findAll()
					   .forEach(b->System.out.println(b));
		*/
		
		//4. 커스텀 정보를 별도로 받아오겠다.
		/*
		boardRepository.findAll()
					   .forEach(b->{
						   System.out.println(b);
						   System.out.println(b.getCustom());
						   System.out.println("------------------------------------------------------------");
					   });
		*/
		
		/*
		 findAll인 경우 - fetchType Eager Lazy 방식 보두 다 조인이 안걸림
		 하지만 한 건의 데이터를가지고 오는 경우...findById()...
		 Eager방식에서 Left 조인이 걸림
		 
		 전체검색 / 한 건 검색이 서로 다르게 동작함
		 
		 엔터티가 결합된 관계에서 굳이 함께 가져와야 하는 필요가 없는 경우에는
		 Lazy방식으로 가져온다
		 반면에 데이터를 함께 가져와야 하는 경우 (게시판 글정보와 함께 글쓴이 정보)에는
		 특히 한 건의 데이터를 직접적으로 받아와야 하는 경우에는 eager
		 */
//		System.out.println(boardRepository.findById(1L)); 
		System.out.println(boardRepository.findById(1L).get().getCustom()); 
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Boot06JpaEntitiesApplication.class, args);
	}

	

}
