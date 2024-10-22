package com.web.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.spring.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	@Query(value="SELECT m FROM Member m WHERE m.id = :id")//첫번째 인자값을 넣겠다.
	Member duplicateCheck(String id);
	
	Member findById(String id); //메소드 오버로딩... id에 해당하는 멤버를 검색
	
//	Optional<Member> findById(Long memberNo); //상속되어 있는 함수
	
	boolean existsById(String id); //메소드 오버로딩... id에 해당하는 멤버를 검색

}
