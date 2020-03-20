package com.hqf;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void text() {
        AbstractApplicationContext context = new
                ClassPathXmlApplicationContext("spring.xml");
//        for (int i = 0; i < 10; i++) {
//            Bean bean = context.getBean("bean", Bean.class);
//            System.out.println(i + ":" + bean);
//        }
//        System.out.println("==============================");
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                Bean bean = context.getBean("bean", Bean.class);
//                System.out.println(Thread.currentThread() + ":" + bean);
//            }).start();
//        }
        Bean bean = context.getBean("bean", Bean.class);
        System.out.println("bean = " + bean);
        context.close();
    }
}
