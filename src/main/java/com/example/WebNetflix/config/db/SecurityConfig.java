package com.example.WebNetflix.config.db;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.WebNetflix.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http
		 	.csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests((authz) -> authz
	            .requestMatchers("/home", "/login", "/css/**", "/js/**", "/vendor/**")
	            .permitAll().anyRequest()
	            .authenticated()	            
	        )
	        .userDetailsService(customUserDetailService)
	        .formLogin(formLogin -> formLogin
	        		.loginPage("/login")
	        		.permitAll()
	        		.defaultSuccessUrl("/login?sucess=true", true)
	        		.failureUrl("/login?success=fail")
	        		 .loginProcessingUrl("/j_spring_security_check")
	        		);
//	        .httpBasic(Customizer.withDefaults());
			
		 return  http.build();
	    }
	 
//	 @Bean
//	 public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//		 return new InMemoryUserDetailsManager(
//		            createUser("user", "123", "USER", passwordEncoder),
//		            createUser("admin", "admin123", "ADMIN" , passwordEncoder)
//		        );
//			}
//	 
//	 private UserDetails createUser(String username, String passWord, String role,  PasswordEncoder passwordEncoder) {
//	        return User.builder()
//	            .username(username)
//	            .password(passwordEncoder().encode(passWord)) // Mã hóa mật khẩu
//	            .roles(role)
//	            .build();
//	    }
	 
	 
	 
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
	 
}
