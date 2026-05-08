package com.care.careathome.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String degree;
    private String experience;
    private String certificateLink;
    private String availabilitySlot;
    private String status;

    public Nurse() {
    }

    public Nurse(Long id, String name, String degree, String experience, String certificateLink, String availabilitySlot, String status) {
        this.id = id;
        this.name = name;
        this.degree = degree;
        this.experience = experience;
        this.certificateLink = certificateLink;
        this.availabilitySlot = availabilitySlot;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCertificateLink() {
        return certificateLink;
    }

    public void setCertificateLink(String certificateLink) {
        this.certificateLink = certificateLink;
    }

    public String getAvailabilitySlot() {
        return availabilitySlot;
    }

    public void setAvailabilitySlot(String availabilitySlot) {
        this.availabilitySlot = availabilitySlot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}