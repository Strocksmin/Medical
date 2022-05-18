package com.example.medical.controller;

import com.example.medical.data.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public String main(Model model) {
        return "/index";
    }
}