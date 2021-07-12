package io.javabrain.SpringSecurity.jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javabrain.SpringSecurity.jwt.entity.UserEntity;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByUsername(String username);
}
