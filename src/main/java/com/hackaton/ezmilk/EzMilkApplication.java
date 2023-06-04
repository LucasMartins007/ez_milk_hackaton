package com.hackaton.ezmilk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.hackaton.ezmilk.repository")
@EntityScan("com.hackaton.ezmilk.model")
public class EzMilkApplication {

	public static void main(String[] args) {
		SpringApplication.run(EzMilkApplication.class, args);
	}

}
