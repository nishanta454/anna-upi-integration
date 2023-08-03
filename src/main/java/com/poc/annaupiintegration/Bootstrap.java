package com.poc.annaupiintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.poc.annaupiintegration.repository") 
public class Bootstrap {

	public static void main(String[] args) {
		log.info("Starting JobRunner");
		SpringApplication.run(Bootstrap.class, args);
		log.info("Exitting JobRunner");
	}
}
