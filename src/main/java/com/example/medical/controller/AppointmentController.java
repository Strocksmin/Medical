package com.example.medical.controller;

import com.example.medical.data.UserData;
import com.example.medical.model.Doctor;
import com.example.medical.model.Proposal;
import com.example.medical.service.DoctorService;
import com.example.medical.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private ProposalService proposalService;

    @GetMapping("/appointment")
    public String appointment(Model model) {
       model.addAttribute("userData", new UserData());
       model.addAttribute("doctors", doctorService.getDoctors());
       return "/appointment";
    }

    @PostMapping("/appointmentquery")
    public String postAppointment(final @Valid UserData userData, final BindingResult bindingResult, final Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("registrationForm", userData);
            model.addAttribute("doctors", doctorService.getDoctors());
            return "/appointment";
        }
        proposalService.addProposal(new Proposal(userData.getDateTime(), userData.getName(),
                userData.getPhone(), userData.getEmail(), userData.getMedic()));
        return "/index";
    }
}
