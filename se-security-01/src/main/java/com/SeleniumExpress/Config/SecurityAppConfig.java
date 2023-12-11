package com.SeleniumExpress.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//as this class has method that will generate SpringSecurityFilterChain Bean
@Configuration
//@EnableWebSecuirty helps to genrate filter chains(chain of filters)
@EnableWebSecurity(debug = true)
public class SecurityAppConfig {

}
