package com.web.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.spring.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	
	//1. 해당 아이디를 받아오는 기능...id가 pk가 아닌, unique라서 jpa에서 제공하는 findById()사용 못함
	//JPQL사용
	 @Query(value = "select m from Member m where m.id = :id")
	//@Query(value="select m from member m where m.id=:?1")//첫번째 인자값을 넣겠다.
	Member duplicateCheck(@Param("id") String id);
	//Member duplicateCheck(@Param("id")String id);둘의 이름이 같으면 생략 가능
	
	//2.아이디가 000이고 패스워드가 000인 사람을 검색
	//JPQL사용
	@Query(value="select m from Member m where m.id=:#{#m.id} and m.pwd =:#{#m.pwd}")
	Member login(Member m);
}
