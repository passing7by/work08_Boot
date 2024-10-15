package com.web.spring.repository;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.spring.entity.Board;
import com.web.spring.entity.BoardIF;

public interface BoardRepository extends JpaRepository<Board, Long>{

	//자동적으로  findAll()..모든 게시글 가져오기
	/*
	 * JPQL을 사용
	 * JPQL은 SQL과 비슷하지만 SQL이 아니다. 객체지향 언어이다.
	 * JPQL에서 from절 뒤에는 테이블명이 아니라 엔터티 이름(반드시 대문자로 시작, 알리아스도 필수)이 나온다!!! 
	 * */
	
	//Board 엔터티는 board테이블과 매핑된 객체이기 때문에 결과적으로 board테이블의 모든 것을 조회하는 쿼리가 완성된다.
	//@Query(value="select b from Board b") //1.조인응 사용해야 한번에 연결된 정보를 함께 가져온다.
	//@Query(value="select b from Board b join b.custom") //2. 조인사용
	@Query(value="select b from Board b join FETCH b.custom") //3. 조인하면서 연관된 정보를 바로 받아오려면 Fetch
	//@Query(value="select b from Board b join Custom c ON b.custom.customId = c.customId") //4.일반적인 조인구문(상세정보는 필드명을 넣어야한다.)
	//@Query(value="select b from Board b join Fetch Custom c ON b.custom.customId = c.customId")//일반적인 쿼리문은 성능저하를 막을 수 없다.
	List<Board> getBoards();
	
	
	//전체 게시글 갯수를 반환...
	@Query(value="select count(b) from Board b")//boardId는 상관없지만 board_id는 에러
	Long getBoardCount();
	
	//관리자 권한을 가지는 사람이 작성한 게시글을 보는 쿼리
	/*
	SELECT * from board b, custom c, role r, custom_role cr
	where b.custom_id = c.custom_id
	and c.custom_id = cr.custom_id
	and cr.role_id = r.role_id
	and r.name='ROLE_ADMIN';
	*/
	/*
	@Query(value="select b,c from Board b join FETCH b.custom c join c.roles r where r.name =:roleName")
	List<Board> getBoards(@Param("roleName") String roleName);*/

	/*
	 * Native Query
	 * 디비로 바로 접근한다.
	 * 벤더 종속적이다.  벤더에 따라서 쿼리문이 다르기 때문이다.
	 * 복잡한 쿼리라서 JPA로 나타내기 힘든 경우 해법이 될 수 있다.
	 * */
	//어떤 사람이 어떤 게시글을 작성했는지 다 볼 수 있는 기능
	//nativeQuery에서는 Board테이블의 모든 컬럼을 다 받아와야한다.. Project알리아스 적용 안됨.
	@Query(value="select b.board_id, b.title, b.content,b.count, b.regDate, b.custom_id, "
			+"c.name from board b, custom c where b.custom_id = c.custom_id",nativeQuery = true)
	List<Board> getBoardsNative();
	//nativeQuery에서 내가 원하는 컬럼만 Project...Board사용 못함
	//Select 절에 나오는 Project을 받아오는 vo를 별도로 작성... 인터페이스로 작성한다.
	@Query(value="select b.board_id, b.title, b.custom_id, c.name "+
			"from board b, custom c where b.custom_id = c.custom_id",nativeQuery = true)
	List<BoardIF> getBoardsNative2();
}
