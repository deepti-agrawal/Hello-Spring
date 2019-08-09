package com.launchcode;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		org.springframework.context.ConfigurableApplicationContext run = run(HelloSpringApplication.class, args);
	}

}
