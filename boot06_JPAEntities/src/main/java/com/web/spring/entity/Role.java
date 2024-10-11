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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	
	@Column(length = 20)
	private String name;
	
	/*
	 롬복을 사용해서 roString을 하면 내부적으로 계속해서 select문이 호출되는 일이 발생....
	 (재귀호출이 일어남)
	 그래서 JPA에서는 롬복을 사용하지 않고 직접 toString을 오버라이딩 해 주는게 좋음
	 */
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + name + "]";
	}
}
/*
 회원과 권한 관계는 N : N
 회원이 권한을 가지고
 권한도 회원을 가지는 관계
 (양방향 관계)
 
 권한이 회원을 가지는 관계로 만들지 않았다
 즉, Custom을 필드로 가지고 있지 않다
 Role을 통해서 Custom 정보를 획득할 수 없다는 얘기
 
 결과적으로 Custom을 통해서만 Role 정보를 받아오도록 할 것임
 */
