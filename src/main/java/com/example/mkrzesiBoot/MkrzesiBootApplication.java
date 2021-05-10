package com.example.mkrzesiBoot;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class MkrzesiBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(MkrzesiBootApplication.class, args);
	}
}