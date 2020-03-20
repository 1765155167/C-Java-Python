package com.hqf;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Bean implements InitializingBean, DisposableBean {

    public void onInit() {
        System.out.println("Bean init");
        System.out.println("Bean init");
        System.out.println("Bean init");
    }

    public void onDestroy() {
        System.out.println("Bean destroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    public Bean() {
        System.out.println("构造函数");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
