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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
//@ToString
public class Custom {
	@Id
	@Column(name = "custom_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customId; 
	
	@Column(length = 500)
	private String password;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 200)
	private String email;
	
	@CreationTimestamp
	private LocalDateTime regDate;
	
	//추가...다대다 관계는 중간에 다대다 관계를 해소하기 위한 조인 테이블/조인 컬럼 필요
	@ManyToMany
	@JoinTable(name="custom_role",
			   joinColumns = @JoinColumn(name="custom_id"),
			   inverseJoinColumns = @JoinColumn(name="role_id"))
	Set<Role> roles = new HashSet<>();
	
	/*
	 toString 함수는 직접 구현한다
	 이때, 연관된 객체는 제외하고 오버라이딩 시킨다
	 */
	@Override
	public String toString() {
		return "Custom [customId=" + customId + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", regDate=" + regDate + "]";
	}
	
	
}
