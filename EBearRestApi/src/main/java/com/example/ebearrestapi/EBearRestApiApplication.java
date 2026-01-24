package com.example.ebearrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EBearRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBearRestApiApplication.class, args);
	}

}
