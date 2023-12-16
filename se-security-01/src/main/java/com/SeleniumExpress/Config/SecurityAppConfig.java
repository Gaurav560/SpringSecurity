package com.SeleniumExpress.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//as this class has method that will generate SpringSecurityFilterChain Bean
@Configuration
//@EnableWebSecuirty helps to genrate filter chains(chain of filters)
@EnableWebSecurity(debug = true)
public class SecurityAppConfig {

	// adding two users and new way of adding user using User Builder in few lines
	// of code

	@Autowired
	HttpSecurity httpSecurity;
	
	
	
	
	@Bean
	public InMemoryUserDetailsManager setUpUser() {

		// design pattern used here for creating object is called builder design pattern

		// creating a user with details of gaurav in one line
		UserDetails userGaurav = User.withUsername("Gaurav").password("{bcrypt}$2a$10$2dPc3.9Q9XIVPW1CEzpbHOvlBdFPskjY0SgN85F2LNLUsHkvsz/xy").roles("admin","customer").build();

		// creating a user with details of amar in one line
		UserDetails userAmar = User.withUsername("Amar").password("{bcrypt}$2a$10$VfIT5zpa46g6ZISkdkJEFeL6sviXezsP13Z6b0B2LAGo/mHwb6zMe").roles("visitor").build();

		return new InMemoryUserDetailsManager(userGaurav, userAmar);

	}
	
	//redefining our own security filtet chain
	@Bean
	SecurityFilterChain settingUpHttpSecurity() throws Exception {
		
		httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
		httpSecurity.formLogin();
		httpSecurity.httpBasic();	
		
		return httpSecurity.build();
	}
	
	
	
	
	

//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}

//	// user koi bhi app ka free content login karke use kar sakta hai par agar wahi
//	// user pay karke us app ka
//	// premium content use karta hai to use wo customer ho jaata hai.
//
//	@Bean
//	public InMemoryUserDetailsManager setUpUser() {
//
//		
//		
//		ArrayList<GrantedAuthority> authorities = new ArrayList<>();
//
//		// u have to pass GrantedAuthority(I) in ArrayList Generic Section
//		// SimpleGrantedAuthrity(C) implemented class of GrantedAuthority(I) and make
//		// its objects
//		// and pass it to add fn of array list
//		authorities.add(new SimpleGrantedAuthority("admin"));
//		authorities.add(new SimpleGrantedAuthority("user"));
//		authorities.add(new SimpleGrantedAuthority("customer"));
//		authorities.add(new SimpleGrantedAuthority("visitor"));
//
//		// creating a user and adding his name,password and authorities
//		UserDetails userDetails = new User("Gaurav", "root",
//				authorities);
//		
//		
//
//		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//		inMemoryUserDetailsManager.createUser(userDetails);
//		return inMemoryUserDetailsManager;
//
//	}
//	
//	
//	
//	
////to not encode password
//
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
}
