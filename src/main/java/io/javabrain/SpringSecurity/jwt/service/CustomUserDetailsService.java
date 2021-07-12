package io.javabrain.SpringSecurity.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.javabrain.SpringSecurity.jwt.config.dto.CustomUserDetails;
import io.javabrain.SpringSecurity.jwt.entity.UserEntity;
import io.javabrain.SpringSecurity.jwt.repository.UserDetailsRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserDetailsRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity userEntity = userRepository.findByUsername(username).orElse(null);

		return new CustomUserDetails(userEntity.getUsername().trim(), userEntity.getPassword().trim(), userEntity.isActive(),
				userEntity.getAuthority());
	}

}
