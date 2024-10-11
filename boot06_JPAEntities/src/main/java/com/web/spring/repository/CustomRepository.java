package com.web.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.Custom;

import java.time.LocalDateTime;
import java.util.List;


/*
 Spring Data JPA Repository...이전의 DAO와 같은 역할
 인터페스가 나오면 해당 인터페이스를 구현한 실체 클래스를 다시 상속받아서 작성해야 하지만
 Spring Data JPA 기술은 인터페이스를 구현하는 빈 클래스를 자동으로 생성시켜 줌
 */
public interface CustomRepository extends JpaRepository<Custom, Integer>{
//아무것도 작성하지 않아도 기본적인 CRUD가 다 들어있음
//JPA Query Method 추가
/*
 JPA Query Method
 1. 대부분 findBy로 시작
 2. 이름 규칙만 잘 정해주면 자동으로  SQL 구문이 실행
 3. ORM 방식이기 때문에 함수명은 CamelCase가 기본
 */
	
	//반환타입은 자유롭게 지정 가능
	
	Optional<List<Custom>> findByName(String name);
	
	//findByLastnameAndFirstname
	Optional<Custom> findByNameAndEmail(String name, String email);
	
	//findByLastnameOrFirstname
	List<Custom> findByNameOrEmail(String name, String email);
	
	//고객의 아이디값이 1~3 사이의 아이디를 가지는 고객을 검색
	Optional<List<Custom>> findByCustomIdBetween(Integer startCustomId, Integer endCustomId);
	
	//고객의 아이디가 3보다 작은 아이디를 가지는 고객을 검색
	Optional<List<Custom>> findByCustomIdLessThan(Integer customId);
	Optional<List<Custom>> findByCustomIdGreaterThan(Integer customId);
	
	//고객의 등록일자가 어제(LocalDateTime) 이후로 등록한 고객을 검색
	Optional<List<Custom>> findByregDateAfter(LocalDateTime date);
	
	//고객의 이름이 null값인 고객을 검색
	List<Custom> findByNameIsNull();
	
	//select * from custom where name like name
	List<Custom> findByNameLike(String name); //와일드카드가 포함되어 있지 않음...값에다 %, _ 를 직접 입력해야 함
	
	//select * from custom where name like %종각
	List<Custom> findByNameEndingWith(String name); //와일드카드가 값의 뒤에 포함되어 있음
	
	List<Custom> findByOrderByCustomIdDesc(); //내림차순
	List<Custom> findByOrderByCustomId(); //오름차순
	
	//고객 아이디가 3보다 큰 아이디를 가지는 고객을 검색 + 아이디를 내림차순 정렬
	//이런식으로 조건검색 뒤에 order by 절은 다 붙일 수 있음
	List<Custom> findByCustomIdGreaterThanOrderByCustomIdDesc(int customId);
	
	List<Custom> findByCustomIdGreaterThanAndNameEndingWith(int customId, String name);
	
	//고객 아이디가 1 혹은 3 혹은 5인 고객을 검색...IN
	List<Custom> findByCustomIdIn(List<Integer> customId);
	
	//Not은 null과 비교하지 않는다...null은 출력되지 않음
	List<Custom> findByNameNot(String name);



}
