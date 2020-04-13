package com.hqf.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwoController {
    @GetMapping("/boot/two")
    Object two() {
        User user = new User("ming", 12);
        return user;
    }
}
