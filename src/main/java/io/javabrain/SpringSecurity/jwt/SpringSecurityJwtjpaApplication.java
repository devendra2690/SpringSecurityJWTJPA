package io.javabrain.SpringSecurity.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.javabrain.SpringSecurity.jwt.repository.UserDetailsRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserDetailsRepository.class)
@EntityScan("io.javabrain.SpringSecurity.jwt.entity")
public class SpringSecurityJwtjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtjpaApplication.class, args);
	}

}
