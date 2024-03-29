package org.simpleapplications.infra.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class InfraModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfraModelApplication.class, args);
	}
}
