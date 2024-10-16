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

import lombok.extern.slf4j.Slf4j;

@EnableWebSecurity
@Configuration
@Slf4j
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		log.info("SecurityFilterChain ==========================================");
		http
			.authorizeHttpRequests(auth -> auth.anyRequest().authenticated()) //어떤 요청이 들어와도 무조건 인증받도록 함
//			.formLogin(Customizer.withDefaults()); //폼 로그인 방식으로 인증받을 것임
			.formLogin(form -> form
//							       .loginPage("/loginPage") //Security가 제공하는 폼을 사용하느라 주석 처리함
							       .loginProcessingUrl("/loginProc")
							       //url명 작성 시 반드시 앞에 '/'를 삽입해야 함!!
							       //loginProcessingUrl()는 디비와 연결되어 인증절차를 수행하고 있을 때 실행됨 (지금은 실행되지 않음 )
							       .usernameParameter("userId") //시큐리티는 id를 username라고 함
							       .passwordParameter("userPass")
							       .defaultSuccessUrl("/",false) //기본이 false, true는 항상 사용
							       .failureUrl("/failed")
							       
							       .successHandler((request, response, authentication) ->{
							    	   response.sendRedirect("/home"); //성공하면 home으로
							       })
							       .failureHandler((request, response, exception) -> {
							    	   response.sendRedirect("/login"); //실패하면 login으로
							       })
							       .permitAll()
			);
		return http.build();
	} //filterChain()
	
	@Bean //반드시 Bean임을 명시해야 함
	public UserDetailsService userDetailsService() {
		log.info("UserDetailsService ==========================================>");
		UserDetails user = User.withUsername("kosta")
							   .password("{noop}7777") //{noop}을 반드시 작성해야만 작동함
							   .roles("USER").build(); //ROLE_가 자동으로 붙는다
		log.info("UserDetailsService ==========================================> user :: {}", user);
		return new InMemoryUserDetailsManager(user); //InMemoryUserDetailsManager : UserDetailsService의 실체 클래스
	} //userDetailsService()
}
