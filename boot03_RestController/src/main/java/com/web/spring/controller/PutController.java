package com.web.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.dto.Member;

@RestController
@RequestMapping("api/v1")
public class PutController {
	/*
	 ResponseEntity를 사용하면 좋은 점~
	 1. 결과 데이터와 함께 상태 코드값을 지정할 수 있음
	 2. 에러코드와 성공여부 상태 코드값을 섬세하게 지정해서 클라이언트에게 전달할 수 있음
	 */
	@PutMapping("/members")
	public ResponseEntity<?> updateMember(@RequestBody Member pvo){
		//201 : create
		//200 : success
		//202 : update
		
		return ResponseEntity
				.status(202)
				.body(pvo);
	}
}
