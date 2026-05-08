package com.care.careathome.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.care.careathome.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
}