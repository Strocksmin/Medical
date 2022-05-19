package com.example.medical.controller;

import com.example.medical.data.MessageData;
import com.example.medical.data.UserData;
import com.example.medical.model.Proposal;
import com.example.medical.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    EmailService emailService;

    @GetMapping("/index")
    public String main(Model model) {
        model.addAttribute("messageData", new MessageData());
        return "/index";
    }

    @PostMapping("/sendMessage")
    public String sendMessage(final MessageData messageData, final Model model) {
        System.out.println("Текст = " + messageData.getText());
        emailService.sendMessageEmail(messageData);
        return "/index";
    }
}
