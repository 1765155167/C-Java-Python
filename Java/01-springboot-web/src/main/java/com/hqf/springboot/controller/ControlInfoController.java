package com.hqf.springboot.controller;

import com.hqf.springboot.config.ConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControlInfoController {
    @Autowired
    private ConfigInfo configInfo;

    @RequestMapping("/boot/config")
    public @ResponseBody String config() {
        //TODO 待办事项
        return "name:" + configInfo.getName() + "; location:" + configInfo.getLocation();
    }
}
