package com.ineuron.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ineuron.ai.SecurityConfiguration.SecurityConfigApp;

@SpringBootApplication
public class SpringSecurityJdbcAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJdbcAuthenticationApplication.class, args);
	}

}
