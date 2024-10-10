package com.web.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data //setter, getter, toString
public class Product {
	private int no;
	private String name;
	private int price;
	private String desc;
}
