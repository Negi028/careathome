package com.care.careathome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.care.careathome.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}