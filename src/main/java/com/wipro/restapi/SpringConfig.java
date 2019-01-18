package com.wipro.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages ={"com.restExample","com"})
@EnableJpaAuditing
public class SpringConfig {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringConfig.class, args);
		System.out.println("hello");
	}

}
