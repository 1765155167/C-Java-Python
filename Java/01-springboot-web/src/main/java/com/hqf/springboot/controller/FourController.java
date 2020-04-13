package com.hqf.springboot.controller;

import jdk.jfr.TransitionTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FourController {
    @GetMapping("boot/four")
    public String four(Model model) {
        model.addAttribute("msg", "你好我是Four");
        return "index";
    }
}
