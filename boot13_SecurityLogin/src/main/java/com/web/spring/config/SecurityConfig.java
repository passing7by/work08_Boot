package com.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.web.spring.jwt.JWTUtil;
import com.web.spring.jwt.LoginFilter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j
@RequiredArgsConstructor
public class SecurityConfig {
	
	//AuthenticationManager 가 위임받을수 있는 AuthenticaitonConfiguration 객체를 생성자로 주입
	private final AuthenticationConfiguration authenticationConfiguration;
	private final JWTUtil jwtUtil;
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
					throws Exception{
		return configuration.getAuthenticationManager();
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		log.info("bCryptPasswordEncoder call ..================>");
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{		
		log.info("SecurityFilterChain===========================>");		
		http
			.csrf((auth)->auth.disable()) 
		    .formLogin((auth)->auth.disable())
		    .httpBasic((auth)->auth.disable());		
		
		http.authorizeHttpRequests((auth)->auth
				.requestMatchers("/index","/members","/members/**","/boards").permitAll()
				.requestMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated()); 	
		
		//추가!!! 중요!!!
		//JWT 사용하는 순간...Session방식 사용안하게 된다.
		http.sessionManagement((session)-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterAt(new LoginFilter(authenticationManager(authenticationConfiguration), jwtUtil), 
										UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}	
}


























