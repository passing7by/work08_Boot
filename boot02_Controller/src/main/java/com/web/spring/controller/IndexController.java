package com.web.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 SSR 방식의 컨트롤러
 결과페이지를 JSP 사용하고
 결과페이지를 서버 사이드에서 생성해서 클라이언트 사이드로 리턴함
 
 1. Boot기반은 jsp를 지원하지 않기 때문에 jsp를 사용하려면 pom.xml에 디펜던시를 별도로 추가해야 함
 2. application.properties 파일에 InternalResourceViewResolver 빈 정보를 설정
 */
@Controller
public class IndexController {
	
	@GetMapping("index")
	public String home(Model model) {
		System.out.println("IndexController...home() call");
		
		model.addAttribute("message", "Hello😎");
		
		return "Result";
	}
}
