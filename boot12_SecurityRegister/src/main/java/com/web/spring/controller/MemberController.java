package com.web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.domain.Member;
import com.web.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {
	
	@Autowired
	private final MemberService memberservice;
	
	//signUp
	@PostMapping("/members")
	public ResponseEntity<?> signUp(@RequestBody Member member) {
		log.info("member signUp ==> {}", member);
		memberservice.signUP(member);
		
		return ResponseEntity
							 .status(201)
							 .body("Register OK");
	}
	
	//duplicateCheck
	@GetMapping("/members/{id}")
	public String duplicateCheck(@PathVariable String id) {
		System.out.println(id);
		
		return memberservice.duplicateCheck(id);
		
	}
	
	
	
	

}
