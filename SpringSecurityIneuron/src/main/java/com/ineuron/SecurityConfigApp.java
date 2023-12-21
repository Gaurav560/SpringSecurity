package com.ineuron;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {

	
	@Bean
	public SecurityFilterChain userDefinedFilterChain(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
		.authorizeHttpRequests
		(request->request
				.requestMatchers("/","/aboutUs","/login")
				.permitAll()
				.anyRequest()
				.authenticated())
		.formLogin();


		return httpSecurity.build();
	}
}
