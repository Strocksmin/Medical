package com.example.medical.controller;

import com.example.medical.data.ProposalData;
import com.example.medical.data.UserData;
import com.example.medical.model.Client;
import com.example.medical.model.Doctor;
import com.example.medical.model.Proposal;
import com.example.medical.service.ClientService;
import com.example.medical.service.DoctorService;
import com.example.medical.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProposalsController {
    @Autowired
    private ProposalService proposalService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/proposals")
    public String proposals(Model model) {
        List<Proposal> list = proposalService.getProposals().stream().limit(5).collect(Collectors.toList());
        model.addAttribute("proposals", list);
        return "/proposals";
    }

    @GetMapping("/proposals/add")
    public String addProp(@RequestParam String name, @RequestParam String phone,
                          @RequestParam String date, @RequestParam String speciality, Model model)
    {
        String newPhone = phone.replace(' ', '+');
        clientService.addClient(new Client(date, name, newPhone, speciality));
        System.out.println(name + phone + date + speciality);
        return "redirect:/proposals";
    }

    @GetMapping("/proposals/del")
    public String delProp(@RequestParam String name, @RequestParam String phone,
                          @RequestParam String date, @RequestParam String speciality, Model model)
    {
        String newPhone = phone.replace(' ', '+');
        proposalService.delete(newPhone);
        System.out.println(name + phone + date + speciality);
        System.out.println(newPhone);
        return "redirect:/proposals";
    }

}
