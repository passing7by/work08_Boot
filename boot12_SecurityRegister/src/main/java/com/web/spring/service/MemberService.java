package com.web.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.domain.Member;
import com.web.spring.exception.MemberAuthenticationException;
import com.web.spring.repository.MemberRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
	
	@Autowired
	private final MemberRepository memberRepository;
	
	@Autowired
	private final PasswordEncoder passwordEncoder;
	
//	//회원 가입, 중복체크
//	@Transactional
//	public void signUP(Member member) {
//	 if(memberRepository.existsById(member.getId()))
//		 throw new MemberAuthenticationException("중복된 아이디ㅣ", "Duplicated ID");
//	 
//	 //비번 암호화
//	 String encPwd = passwordEncoder.encode(member.getPwd());
//	 log.info("encPwd ==> {}", encPwd);
//	 member.setPwd(encPwd);
//	 
//	 //Role 설정
//	 member.setRole("ROLE_USER"); //지금은 앞부분에 ROLE_을 자동으로 붙여주지 않음...
//	 
//	 Member savedMember = memberRepository.save(member);
//	 log.info("savedMember ==> {}", savedMember);
//	}
	
	//회원 가입, 중복체크
		@Transactional
		public void signUP(Member member) {
		 if(memberRepository.existsById(member.getId())) {
			 throw new MemberAuthenticationException("중복된 아이디", "Duplicated Id!!");
		 }
		 
		 if (member.getPwd() == null || member.getPwd().isEmpty()) {
		        throw new MemberAuthenticationException("비밀번호가 필요합니다", "Password is required");
		    }
		 
		 //비번 암호화
		 String encPwd =passwordEncoder.encode(member.getPwd());
		 log.info("encPwd ==>{}",encPwd);
		 member.setPwd(encPwd);
		 //ROLE설정
		 member.setRole("ROLE_USER");//지금은 앞부분에 ROLE을 지정하지 않는다.
		
		 Member savedMember= memberRepository.save(member);
		
		 log.info("savedMember ==>{}",savedMember);
		}
	
	@Transactional
	public String duplicateCheck(String id) {
		Member rm = memberRepository.duplicateCheck(id);
		System.out.println("rm=>"+rm);
		if(rm==null)return "아이디 사용가능";
		else return"아이디 사용 불가!!";
	}
	
}
