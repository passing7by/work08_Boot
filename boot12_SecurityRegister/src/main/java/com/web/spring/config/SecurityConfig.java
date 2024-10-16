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
		
		//인증방식 설정
		http
			.csrf((auth) -> auth.disable())
			.formLogin((auth) -> auth.disable())
			.httpBasic((auth) -> auth.disable());
		
		//인가정책 설정
		http.authorizeHttpRequests((auth) -> auth
												 .requestMatchers("/index", "/members", "/member/**", "/boards").permitAll()

												 .requestMatchers("/admin").hasRole("ADMIN")
												 .anyRequest().authenticated()
								   );
		 log.info("SecurityFilterChain =======================>");
		
		return http.build();
	} //filterChain()
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() { //비밀번호 암호화
		log.info("BCryptPasswordEncoder call .. ===================>");
		
		return new BCryptPasswordEncoder();
	} //bCryptPasswordEncoder()
}
