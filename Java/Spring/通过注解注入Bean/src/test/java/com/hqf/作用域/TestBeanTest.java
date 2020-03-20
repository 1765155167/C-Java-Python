package com.hqf.作用域;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class TestBeanTest {

    @Test
    public void test() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
        for (int i = 0; i < 10; i++) {
            TestBean testBean = context.getBean("bean1", TestBean.class);
            System.out.println("testBean1 = " + testBean);
        }
        System.out.println("==============================");
        for (int i = 0; i < 10; i++) {
            TestBean testBean = context.getBean("bean2", TestBean.class);
            System.out.println("testBean2 = " + testBean);
        }
        System.out.println("==============================");
        for (int i = 0; i < 10; i++) {
            TestBean testBean = context.getBean("bean3", TestBean.class);
            System.out.println("testBean3 = " + testBean);
        }
        System.out.println("==============================");
        TestBean1 testBean1 = context.getBean("testBean2", TestBean1.class);
        System.out.println("testBean2 = " + testBean1);
        context.close();
    }
}
