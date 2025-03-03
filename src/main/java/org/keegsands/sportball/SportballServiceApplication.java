package org.keegsands.sportball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "org.keegsands.sportball")
public class SportballServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportballServiceApplication.class, args);
	}

}
