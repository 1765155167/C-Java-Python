package com.hqf.class002;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class002Text {
    @Test
    public void text() {
        //获取Spring上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //获取Bean
        Bean bean = context.getBean("bean", Bean.class);
        System.out.println("Bean = " + bean);
    }
}
