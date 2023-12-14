package com.SeleniumExpress.Config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//as this class has method that will generate SpringSecurityFilterChain Bean
@Configuration
//@EnableWebSecuirty helps to genrate filter chains(chain of filters)
@EnableWebSecurity(debug = true)
public class SecurityAppConfig {
	// user koi bhi app ka free content login karke use kar sakta hai par agar wahi
	// user pay karke us app ka
	// premium content use karta hai to use wo customer ho jaata hai.

	@Bean
	public InMemoryUserDetailsManager setUpUser() {

		
		
		ArrayList<GrantedAuthority> authorities = new ArrayList<>();

		// u have to pass GrantedAuthority(I) in ArrayList Generic Section
		// SimpleGrantedAuthrity(C) implemented class of GrantedAuthority(I) and make
		// its objects
		// and pass it to add fn of array list
		authorities.add(new SimpleGrantedAuthority("admin"));
		authorities.add(new SimpleGrantedAuthority("user"));
		authorities.add(new SimpleGrantedAuthority("customer"));
		authorities.add(new SimpleGrantedAuthority("visitor"));

		// creating a user and adding his name,password and authorities
		UserDetails userDetails = new User("Gaurav", "root",
				authorities);
		
		

		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		inMemoryUserDetailsManager.createUser(userDetails);
		return inMemoryUserDetailsManager;

	}
	
	
	
	
//to not encode password

	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
