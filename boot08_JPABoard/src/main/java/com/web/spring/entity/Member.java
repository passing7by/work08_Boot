package com.web.spring.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * 생성자 패턴....생성자는 인자가 많을 때 순서가 바뀌기 쉽다.
 * Blog blog = new Blog(0,0,0,0);
 * 
 * 빌드패턴
 * Blog blog = Blog.builder()
 * 					.name("kosta")
 * 					.id("1234")
 * 					.memo("존재하는 이름이 없습니다.")
 * 					.builder();
 * -생성자 오버로딩을 대신한다. 고로 정확도를 지킬 수 있다.
 * 1. 빌더의 각 값들이 생성자 말고 빌더를 통해서 주입.. 정확도가 높다.
 * 2. 생성자보다 가독력도 좋다.
 * 3. 다양한 인자값으로 객체 생성시... 생성자 오버로딩시... 빌드 패턴으로 많이 하는 추세이다.
 * */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder //추가-
public class Member {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberNo;
	
	@Column(unique = true)
	private String id;
	@Column(length = 20)
	private String pwd;
	
	private String name;
	
	private String address;
	@CreationTimestamp
	private LocalDateTime regDate;

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", address="
				+ address + ", regDate=" + regDate + "]";
	}
	
	
	
}
