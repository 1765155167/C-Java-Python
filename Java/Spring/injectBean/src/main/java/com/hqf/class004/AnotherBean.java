package com.hqf.class004;

import org.springframework.beans.factory.InitializingBean;

public class AnotherBean implements InitializingBean {
    String name;

    public AnotherBean(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("print...");
    }

    public AnotherBean() {
    }

    @Override//
    public void afterPropertiesSet() throws Exception {
        // do some initialization work
        System.out.println("do some initialization work");
    }
}
