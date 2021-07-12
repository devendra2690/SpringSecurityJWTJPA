package io.javabrain.SpringSecurity.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import io.javabrain.SpringSecurity.jwt.entity.UserEntity;
import io.javabrain.SpringSecurity.jwt.repository.UserDetailsRepository;

@Component
public class PreloadProcess implements CommandLineRunner {

	@Autowired
	UserDetailsRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();

		UserEntity entity = new UserEntity();
		entity.setUsername("user");
		entity.setPassword(passwordEncoder.encode("user"));
		entity.setAuthority("USER");
		entity.setActive(true);

		userRepository.save(entity);
	}

}
