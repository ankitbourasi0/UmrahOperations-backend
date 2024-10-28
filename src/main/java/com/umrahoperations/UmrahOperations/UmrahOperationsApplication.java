package com.umrahoperations.UmrahOperations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.umrahoperations.UmrahOperations.repository")
public class UmrahOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmrahOperationsApplication.class, args);
	}


}
