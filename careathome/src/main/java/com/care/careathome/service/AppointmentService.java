package com.care.careathome.service;

import org.springframework.stereotype.Service;

import com.care.careathome.entity.Appointment;

@Service
public class AppointmentService {

    public void process(Appointment a) {

        if (a.getService() == null) return;

        switch (a.getService()) {

            case "Injection":
                a.setAssignedNurse("Junior Nurse");
                a.setCost(300);
                break;

            case "Dressing":
                a.setAssignedNurse("Dressing Specialist");
                a.setCost(500);
                break;

            case "Chemotherapy":
                a.setAssignedNurse("Oncology Nurse");
                a.setCost(1500);
                break;

            case "ICU Care":
                a.setAssignedNurse("Critical Care Nurse");
                a.setCost(2500);
                break;

            default:
                a.setAssignedNurse("General Nurse");
                a.setCost(200);
        }

        a.setStatus("PENDING");
    }
}