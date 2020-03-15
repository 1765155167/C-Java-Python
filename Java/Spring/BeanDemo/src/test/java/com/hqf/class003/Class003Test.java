package com.hqf.class003;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class003Test {
    @Test
    public void text() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");
        //构造方法实例化Bean
        Bean1 bean1 = context.getBean("bean1", Bean1.class);
        System.out.println("Bean1" + bean1);
        //静态工厂方法
        Bean2 bean2 = context.getBean("bean2", Bean2.class);
        System.out.println("Bean2" + bean2);
        //通过实例方法实例化Bean
        Bean3 bean3 = context.getBean("bean3", Bean3.class);
        System.out.println("Bean3" + bean3);
        //Bean别名
        Bean1 bean1_1 = context.getBean("bean1_1", Bean1.class);
        Bean1 bean1_2 = context.getBean("bean1_2", Bean1.class);
        Bean1 bean1_3 = context.getBean("bean1_3", Bean1.class);
        System.out.println("Bean1_1" + bean1_1);
        System.out.println("Bean1_2" + bean1_2);
        System.out.println("Bean1_3" + bean1_3);
    }
}
