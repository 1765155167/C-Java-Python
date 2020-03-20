package com.hqf;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class Class004Text {
    @Test
    public void text()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Bean bean = context.getBean("bean", Bean.class);
        System.out.println("bean = " + bean);
        var list = bean.getStringList();
        for (String s : list) {
            System.out.println("s = " + s);
        }
        var map = bean.getMap();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
}
