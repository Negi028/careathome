package com.care.careathome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.care.careathome.entity.Nurse;

public interface NurseRepository extends JpaRepository<Nurse, Long> {

    List<Nurse> findByStatus(String status);

    List<Nurse> findByAvailabilitySlot(String availabilitySlot);
}