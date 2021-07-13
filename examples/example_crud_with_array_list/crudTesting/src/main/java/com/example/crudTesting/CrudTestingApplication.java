package com.example.crudTesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.crudTesting")
@EnableAutoConfiguration
public class CrudTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudTestingApplication.class, args);
	}

}
