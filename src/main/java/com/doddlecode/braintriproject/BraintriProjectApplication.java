package com.doddlecode.braintriproject;

import com.doddlecode.braintriproject.repository.EmployeeRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class BraintriProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BraintriProjectApplication.class, args);
	}

	@Bean
	ApplicationRunner init(EmployeeRepository repository) {
		return args -> {
		};
	}
}
