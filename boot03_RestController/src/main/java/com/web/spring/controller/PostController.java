package com.web.spring.controller;


import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.dto.Member;

@RestController
@RequestMapping("api/v1")
public class PostController {
	//데이터 전달이 목적..request객체의 body에 담겨져서 전달되는 값을 받는다
	@PostMapping("/members")
	public String insertMember(@RequestBody Member pvo) {
		//service 함수 호출 insert dao 디비
		return pvo.toString();
	}
	
	@PostMapping("/members2")
	public String insertmemver2(@RequestBody Map<String, String> data) {
		StringBuilder sb = new StringBuilder();
		data.entrySet().forEach(map->{
			sb.append(map.getKey() + " : " + map.getValue() + " ");
		});
		
		return sb.toString();
	}
}
