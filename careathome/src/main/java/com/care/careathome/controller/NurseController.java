package com.care.careathome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.care.careathome.entity.Nurse;
import com.care.careathome.repository.NurseRepository;

@Controller
public class NurseController {

    @Autowired
    private NurseRepository nurseRepo;

    @GetMapping("/nurse-apply")
    public String nurseApplyPage() {
        return "nurse-apply";
    }

    @PostMapping("/nurse-apply")
    public String nurseApply(Nurse nurse) {
        nurse.setStatus("PENDING");
        nurseRepo.save(nurse);
        return "redirect:/";
    }
}