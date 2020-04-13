package com.hqf.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OneController {

    @RequestMapping("boot/one")
    @ResponseBody
    Object one() {
        User user = new User("hqf", 20);
        return user;
    }
}
