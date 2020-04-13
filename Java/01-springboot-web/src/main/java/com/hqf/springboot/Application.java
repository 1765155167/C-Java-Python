package com.hqf.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    //启动SpringBoot程序，启动spring容器，启动内嵌的tomcat
    public static void main(String[] args) {
        //启动SpringBoot程序，启动spring容器，启动内嵌的tomcat
        SpringApplication.run(Application.class, args);
        System.out.println("根地址：\t\thttp://127.0.0.1:8080/01-springboot-web/boot/getUser");
    }
}
