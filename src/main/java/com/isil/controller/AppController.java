package com.isil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {

//    @GetMapping
//    public String defaultPage(){
//        return "redirect:/menu";
//    }

    @GetMapping("/login")
    public String login(){
        return "index";
    }

}
