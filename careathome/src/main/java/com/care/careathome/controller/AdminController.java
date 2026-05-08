package com.care.careathome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.careathome.entity.Nurse;
import com.care.careathome.repository.AppointmentRepository;
import com.care.careathome.repository.NurseRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

    private final String ADMIN_USERNAME = "akashadmin";
    private final String ADMIN_PASSWORD = "Akash@123";

    @Autowired
    private AppointmentRepository appointmentRepo;

    @Autowired
    private NurseRepository nurseRepo;

    @GetMapping("/admin-login")
    public String adminLoginPage() {
        return "admin-login";
    }

    @PostMapping("/admin-login")
    public String adminLogin(@RequestParam String username,
                             @RequestParam String password,
                             HttpSession session,
                             Model model) {

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            session.setAttribute("admin", true);
            return "redirect:/admin";
        }

        model.addAttribute("error", "Invalid admin username or password");
        return "admin-login";
    }

    @GetMapping("/admin")
    public String adminDashboard(HttpSession session, Model model) {

        if (session.getAttribute("admin") == null) {
            return "redirect:/admin-login";
        }

        model.addAttribute("appointments", appointmentRepo.findAll());
        model.addAttribute("nurses", nurseRepo.findAll());

        return "admin";
    }

    @GetMapping("/approve-nurse")
    public String approveNurse(@RequestParam Long id, HttpSession session) {

        if (session.getAttribute("admin") == null) {
            return "redirect:/admin-login";
        }

        Nurse nurse = nurseRepo.findById(id).orElse(null);

        if (nurse != null) {
            nurse.setStatus("APPROVED");
            nurseRepo.save(nurse);
        }

        return "redirect:/admin";
    }

    @GetMapping("/admin-logout")
    public String adminLogout(HttpSession session) {
        session.removeAttribute("admin");
        return "redirect:/admin-login";
    }
}