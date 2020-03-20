package com.hqf.作用域;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("testBean1")
@Scope("singleton")//作用域单例模式
@Lazy //设置懒加载模式
public class TestBean1 implements InitializingBean, DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("TestBean1.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("TestBean1.afterPropertiesSet");
    }

    public void onInit() {
        System.out.println("TestBean1.onInit");
    }

    public void onDestroy() {
        System.out.println("TestBean1.onDestroy");
    }
}
