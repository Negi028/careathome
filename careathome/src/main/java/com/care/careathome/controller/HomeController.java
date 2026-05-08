package com.care.careathome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.careathome.entity.Appointment;
import com.care.careathome.entity.User;
import com.care.careathome.repository.AppointmentRepository;
import com.care.careathome.repository.NurseRepository;
import com.care.careathome.service.AppointmentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private AppointmentRepository appointmentRepo;

    @Autowired
    private NurseRepository nurseRepo;

    @Autowired
    private AppointmentService service;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/services")
    public String services() {
        return "services";
    }

    @GetMapping("/book")
    public String bookPage(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        if (user.getPrescriptionLink() == null || user.getPrescriptionLink().trim().isEmpty()) {
            return "redirect:/dashboard";
        }

        model.addAttribute("appointment", new Appointment());
        return "booking";
    }

    @PostMapping("/book")
    public String saveAppointment(Appointment appointment, HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        if (user.getPrescriptionLink() == null || user.getPrescriptionLink().trim().isEmpty()) {
            return "redirect:/dashboard";
        }

        service.process(appointment);
        appointmentRepo.save(appointment);

        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/complete")
    public String complete(@RequestParam Long id, HttpSession session) {

        if (session.getAttribute("admin") == null) {
            return "redirect:/admin-login";
        }

        Appointment appointment = appointmentRepo.findById(id).orElse(null);

        if (appointment != null) {
            appointment.setStatus("COMPLETED");
            appointmentRepo.save(appointment);
        }

        return "redirect:/admin";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, HttpSession session) {

        if (session.getAttribute("admin") == null) {
            return "redirect:/admin-login";
        }

        appointmentRepo.deleteById(id);
        return "redirect:/admin";
    }
}