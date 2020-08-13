package com.springboot.web.springbootfirstwebapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dao.MyRepo;

@SpringBootApplication
@ComponentScan("com.springboot.web")
@EntityScan(basePackages = "com")
@EnableJpaRepositories(basePackages = "com")

public class SpringbootFirstwebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFirstwebappApplication.class, args);
	}
	
}
