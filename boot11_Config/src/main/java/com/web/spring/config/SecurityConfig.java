package com.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;


@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//인증방식과 인가정책을 지정...
		
		log.info("SecurityFilterChain =======================>");
		
		http.csrf((auth) -> auth.disable());
		//csrf를 비활성화 시킴
		//csrf 공격을 방어하기 위한 토큰 주고받는 부분을 비활성화
		http.formLogin((auth) -> auth.disable());
		/*
		 * 1. security에서 제공하는 폼을 비활성화
		 * 2. 앞으로는 React를 활용 => 폼 로그인은 필요X
		 * 3. formLogin을 disable하면 인증 시큐리티 아키텍처에서 사용하지 않는 부분이 있음
		 * 	  => UsernamePasswordAuthenticationFilter를 무력화시키는 방식으로 인증방식을 변경할거임
		 */
		http.httpBasic((auth) -> auth.disable());
		
		//경로별 인가작업
		http.authorizeHttpRequests((auth) -> auth
												 .requestMatchers("/index", "/members", "/member/**", "/boards").permitAll()
												 // QUES : 내가 없을 때 배운 내용..???
												 //permitAll() : 인증 없이도 해당 url에 대한 접근을 허용함
												 .requestMatchers("/admin").hasRole("ADMIN")
												 .anyRequest().authenticated() //위의 모든 인증을 거쳐서 여기로 들어 옴
				);
		 log.info("SecurityFilterChain =======================>");

		
		return http.build();
	} //filterChain()
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		log.info("BCryptPasswordEncoder call .. ===================>");
		
		return new BCryptPasswordEncoder();
	} //bCryptPasswordEncoder()
}
