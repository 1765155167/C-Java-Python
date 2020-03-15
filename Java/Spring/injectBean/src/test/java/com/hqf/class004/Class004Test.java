package com.hqf.class004;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class004Test {
    @Test
    public void text() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");
        Bean bean = context.getBean("bean", Bean.class);
        System.out.println("bean.getAnotherBeanList() = " + bean.getAnotherBeanList());
        System.out.println("bean.getAnotherBeanSet() = " + bean.getAnotherBeanSet());
        System.out.println("bean.getAnotherBeanStringMap() = " + bean.getAnotherBeanStringMap());
        System.out.println("bean.getStringList() = " + bean.getStringList());
        System.out.println("bean.getStringSet() = " + bean.getStringSet());
        System.out.println("bean.getStringAnotherBeanMap() = " + bean.getStringAnotherBeanMap());
        System.out.println("bean.getProperty() = " + bean.getProperties());
        System.out.println("bean.getAnotherBean2() = " + bean.getAnotherBean2());
        System.out.println("bean.getAnotherBean1() = " + bean.getAnotherBean1());
    }
}
