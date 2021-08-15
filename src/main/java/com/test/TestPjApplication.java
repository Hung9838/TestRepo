package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TestPjApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestPjApplication.class, args);
	}

}
