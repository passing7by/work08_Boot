package com.web.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.entity.Member;
import com.web.spring.service.MemberService;

import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberservice;
	
	
	//signUp
	@PostMapping("/members")
	public String signUp(@RequestBody Member member) {
		
		memberservice.signUP(member);
		
		return "OK";
		
	}
	
	//duplicateCheck
	@GetMapping("/members/{id}")
	public String duplicateCheck(@PathVariable String id) {
		System.out.println(id);
		
		
		return memberservice.duplicateCheck(id);
		
	}
	
	//signIn
	@PostMapping("/members/login")
	public Member signIn(@RequestBody Member member) {
	Member rm =	memberservice.signIn(member.getId(), member.getPwd());
	
	return rm;//Client로 데이터가 날아간다..Json으로 변환해서 날라갈 것이다.
	}
	
	

}
