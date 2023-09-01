package com.ugea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.ugea.model")
public class UgeaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UgeaApplication.class, args);
	}

}
