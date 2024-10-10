package com.web.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data //setter, getter, toString
public class Member {
	private String id;
	private String password;
	private String name;
	private String address;
}
