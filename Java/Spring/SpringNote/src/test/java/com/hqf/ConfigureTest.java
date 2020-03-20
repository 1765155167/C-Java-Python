package com.hqf;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigureTest {

    @Test
    public void test() {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(MyConfiguration2.class);
        Bean1 bean1 = context.getBean("bean", Bean1.class);
        System.out.println("bean1 = " + bean1);
    }
}
