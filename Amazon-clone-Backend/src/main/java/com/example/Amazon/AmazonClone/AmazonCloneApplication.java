package com.example.Amazon.AmazonClone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.Amazon.AmazonClone.Repositories")
@EntityScan("com.example.Amazon.AmazonClone.Model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")

@SpringBootApplication
public class AmazonCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonCloneApplication.class, args);
	}


}
