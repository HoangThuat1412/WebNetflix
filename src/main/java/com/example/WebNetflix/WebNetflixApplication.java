package com.example.WebNetflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

public class WebNetflixApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebNetflixApplication.class, args);
	}

}
