package com.hqf.factory;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建一个Bean工厂
 * Bean：可重用的组件
 * JavaBean：用Java语言编写的可重用组件
 * 1.需要一个配置文件来配置我们的类
 * 2.通过配置文件的内容，反射创建对象
 */
public class BeanFactory {

    private static Properties props;
    private static Map<String, Object> beans;
    private static Logger log;

    //使用静态代码块为props赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取properties文件流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<>();
            //实例化日志类
            log = LoggerFactory.getLogger(BeanFactory.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化错误");
        }
    }

    public static Object getBean(String beanName) {
        Object object = beans.get(beanName);
        if (object != null) {
            return object;
        }
        try {
            String beanPath = props.getProperty(beanName);
            object = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        beans.put(beanName, object);
        return object;
    }
}
