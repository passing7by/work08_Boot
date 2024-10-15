package com.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	//인증 관련 설정은...SecurityFilterChain
	//SecurityFilterChain을 빈으로 지정.. 여기다가 인증 관련된 인가 정책을 등록
	//members/ 라는 요청이 들어오면 인증을 할건지 말건지 등,,,
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		//여기다가 http 요청에 대한 인증과 권한 관련된 인가 정책을 등록..7버전 부터는 모든 코드를 람다 형식으로 작성하도록 규정되어 있음
		http
			.authorizeHttpRequests(auth->auth.anyRequest().authenticated()) //어떤 요청에도 인증받겠다는 뜻
			.formLogin(Customizer.withDefaults()); //디폴트 방식인 로그인폼으로 인증받겠다는 뜻
		return http.build(); //SecurityFilterChain이 반환됨
	}
	
	//UserDetailsService빈을 등록하고.. 디비 연결했다 치고.. id, password 정보를 InMemory
	//properties 설정파일에도 User 정보를 등록했음.... 이럴 때는 UserDetailsService 빈 설정이 우선순위가 높음
	@Bean //반드시 Bean임을 명시해야 함
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("security")
							   .password("{noop}7777") //{noop}을 반드시 작성해야만 작동함
							   .roles("USER").build();
		UserDetails user1 = User.withUsername("security1")
				   .password("{noop}7777") //{noop}을 반드시 작성해야만 작동함
				   .roles("USER").build();
		
		UserDetails user2 = User.withUsername("security2")
				   .password("{noop}7777") //{noop}을 반드시 작성해야만 작동함
				   .roles("USER").build();
		return new InMemoryUserDetailsManager(user, user1, user2); //InMemoryUserDetailsManager : UserDetailsService의 실체 클래스
	}
}
