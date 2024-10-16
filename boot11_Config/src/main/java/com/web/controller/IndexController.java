package com.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class IndexController {
	
	@GetMapping("/index")
	public String index() {
		log.info("index controller call...");
		
		return "Spring Security Index";
	}
	
}
