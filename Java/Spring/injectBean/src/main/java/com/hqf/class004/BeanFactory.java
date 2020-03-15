package com.hqf.class004;

public class BeanFactory {
    public AnotherBean getBean() {
        return new AnotherBean();
    }
    public static AnotherBean getStaticBean() {
        return new AnotherBean();
    }
}
