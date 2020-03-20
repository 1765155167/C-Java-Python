package com.hqf;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Text {
    @Test
    public void test() {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("spring.xml");
        Class1 class1 = context.getBean("class1", Class1.class);
        System.out.println("class1 = " + class1);
        Class2 class2 = context.getBean("class2", Class2.class);
        System.out.println("class2 = " + class2);
    }
}
