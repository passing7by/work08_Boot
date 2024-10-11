package com.web.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends JpaRepository<User, String>{ //<enetity, pk의 타입>

	//user가 포함된(%user%) 아이디 검색 후 아이디 오름차순 정렬
	List<Optional<User>> findByIdContainingOrderById(String id);
	
	//user가 포함되어 있지 않은(%user%가 아닌) 아이디 검색 후 아이디 오름차순 정렬
	List<Optional<User>> findByIdNotContainingOrderById(String id);
	
	//user02, user03이 아닌 아이디 검색 후 아이디 오름차순 정렬
	List<Optional<User>> findByIdNotInOrderById(List<String> id);


	//
	
//	Optional<List<Custom>> findByName(String name);
//	
//	//findByLastnameAndFirstname
//	Optional<Custom> findByNameAndEmail(String name, String email);
//	
//	//findByLastnameOrFirstname
//	List<Custom> findByNameOrEmail(String name, String email);
//	
//	//고객의 아이디값이 1~3 사이의 아이디를 가지는 고객을 검색
//	Optional<List<Custom>> findByCustomIdBetween(Integer startCustomId, Integer endCustomId);
//	
//	//고객의 아이디가 3보다 작은 아이디를 가지는 고객을 검색
//	Optional<List<Custom>> findByCustomIdLessThan(Integer customId);
//	Optional<List<Custom>> findByCustomIdGreaterThan(Integer customId);
//	
//	//고객의 등록일자가 어제(LocalDateTime) 이후로 등록한 고객을 검색
//	Optional<List<Custom>> findByregDateAfter(LocalDateTime date);
//	
//	//고객의 이름이 null값인 고객을 검색
//	List<Custom> findByNameIsNull();
//	
//	//select * from custom where name like name
//	List<Custom> findByNameLike(String name); //와일드카드가 포함되어 있지 않음...값에다 %, _ 를 직접 입력해야 함
//	
//	//select * from custom where name like %종각
//	List<Custom> findByNameEndingWith(String name); //와일드카드가 값의 뒤에 포함되어 있음
//	
//	List<Custom> findByOrderByCustomIdDesc(); //내림차순
//	List<Custom> findByOrderByCustomId(); //오름차순
//	
//	//고객 아이디가 3보다 큰 아이디를 가지는 고객을 검색 + 아이디를 내림차순 정렬
//	//이런식으로 조건검색 뒤에 order by 절은 다 붙일 수 있음
//	List<Custom> findByCustomIdGreaterThanOrderByCustomIdDesc(int customId);
//	
//	List<Custom> findByCustomIdGreaterThanAndNameEndingWith(int customId, String name);
//	
//	//고객 아이디가 1 혹은 3 혹은 5인 고객을 검색...IN
//	List<Custom> findByCustomIdIn(List<Integer> customId);
//	
//	//Not은 null과 비교하지 않는다...null은 출력되지 않음
//	List<Custom> findByNameNot(String name);



}
