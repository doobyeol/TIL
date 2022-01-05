package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = {"com.example.demo.mvc.repository"})
@MapperScan(basePackages = "com.example.demo") 
@SpringBootApplication
@EnableScheduling
public class ExampleSpringApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ExampleSpringApplication.class, args);
	}

}