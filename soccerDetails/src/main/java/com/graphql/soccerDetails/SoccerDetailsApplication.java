package com.graphql.soccerDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.graphql.soccerDetails.config" })
public class SoccerDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoccerDetailsApplication.class, args);
	}
}
