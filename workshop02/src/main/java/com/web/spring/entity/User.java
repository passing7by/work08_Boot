package com.web.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity //db테이블과 매핑되는 객체
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User {
	@Id
	@Column(name="id")
	private String id;
	
	@Column(length = 500)
	private String password;
	
	@Column(length = 50)
	private String name;
}
