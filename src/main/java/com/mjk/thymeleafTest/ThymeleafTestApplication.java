package com.mjk.thymeleafTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@RestController
public class ThymeleafTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafTestApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
}
