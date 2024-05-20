package com.example.sparkintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.*")
public class SparkIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparkIntegrationApplication.class, args);

		
	}

}
