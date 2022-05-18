package com.example.medical.controller;

import com.example.medical.data.UserData;
import com.example.medical.model.Doctor;
import com.example.medical.model.Proposal;
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

    List<Proposal> proposals = new ArrayList<>();

   @GetMapping("/appointment")
    public String appointment(Model model) {
       model.addAttribute("userData", new UserData());
       return "/appointment";
    }

    @PostMapping("/appointmentquery")
    public String postAppointment(final @Valid UserData userData, final BindingResult bindingResult, final Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("registrationForm", userData);
            return "/appointment";
        }
        System.out.println(userData);
        proposals.add(new Proposal(userData.getDateTime(), userData.getName(),
                userData.getPhone(), userData.getEmail(), userData.getMedic()));
        return "/appointment";
    }
}
