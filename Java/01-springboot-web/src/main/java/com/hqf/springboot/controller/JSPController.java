package com.hqf.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSPController {
    @GetMapping("/boot/index")
    public String index(Model model) {
        model.addAttribute("msg", "springboot 集成 JSP");

        return "index";
    }
}
