package com.web.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.dto.Member;

/*
 단순한 페이지를 요청하는 Get 방식의 Controller 를 다뤄보겠다.
 */

@RestController
public class GetController {
	
	@GetMapping("/members")
	public String getMember(String id) {
		//서비스 함수 호출 결과로 id에 해당하는 Member 객체를 리턴받았다 치고
		Member rvo = new Member("kosta", "1234", "홍종각", "종각");
		return rvo.toString();
	}
	
	//2. http://localhost:9000/member?name=홍종각&address=종각
	@GetMapping("/member")
	public String getMember(@RequestParam String name, @RequestParam String address) { //@RequestParam : 폼에 입력된 값
		return name + " 님이 사는 곳은 " + address + "입니다🐱‍";
	}	
	
//	//3. http://localhost:9000/member/James
//	@GetMapping("/member/{name}")
//	public String getMemberName(@PathVariable String name) { 
//		return "Hello " + name;
//	}
	
//	@GetMapping("/member/{name}")
//	public String getMemberName(@PathVariable String myName) { 
//		return "Hello " + myName; //405 에러 발생
//	}
	
	@GetMapping("/member/{name}")
	public String getMemberName(@PathVariable("name") String myName) { 
		return "Hello " + myName; //정상작동
	}
}