package com.hqf.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MVCController {
    @GetMapping("/boot/getUser")
    private Object getUser() {
        User user = new User("hqf", 12);
        return user;
    }
    @PostMapping("/boot/postUser")
    private Object postUser() {
        User user = new User("hqf", 12);
        return user;
    }
}
