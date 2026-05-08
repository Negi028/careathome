package com.care.careathome.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.care.careathome.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}