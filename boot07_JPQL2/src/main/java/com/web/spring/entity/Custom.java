package com.web.spring.entity;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity  //db테이블과 매핑되는 객체.. 자동으로 테이블명은 custom으로 잡힘
@Table(name="custom") //엔터티 클래스 명과 테이블 명이 다를 때 지정
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
//@ToString
public class Custom {

	@Id //유일한 값 PK
	@Column(name="custom_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customId;//custom_id로 자동으로 컬럼명이 잡힌다.
	
	@Column(length = 500)
	private String password;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 200)
	private String email;
	
	@CreationTimestamp
	private LocalDateTime regDate;//고객이 등록될때 시간이 자동으로 생성
	
	//추가...다대다... 중간에 다대다 관계를 해소하기 위한 조인테이블/조인컬럼
	@ManyToMany
	@JoinTable(name="custom_role",
	joinColumns= @JoinColumn(name="custom_id"),
	inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles  = new HashSet<>();

	
	/* JPA에서
	 * toString은 직접 구현한다.
	 * 이떄 연관된 객체는 제외하고 오버라이딩 시킨다.
	 * */
	@Override
	public String toString() {
		return "Custom [customId=" + customId + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", regDate=" + regDate + "]";
	}
	
}
