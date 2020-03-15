package com.hqf.class001;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 1.实例化Bean
 * 2.保存Bean
 * 3.提供Bean
 * 4.每一个Bean要产生一个唯一的id与之对应
 */
public class IOCContainer {
    private Map<String, Object> beans = new ConcurrentHashMap<>();

    /**
     * 根据beanId获取一个Bean
     * @param beanId
     * @return
     */
    public Object getBean(String beanId) {
        return beans.get(beanId);
    }

    /**
     * 委托ioc创建一个bean
     * @param clazz 要创建的bean的class
     * @param beanId
     * @param paramBeanIds 要创建的bean的class的构造方法所需要的beanId们
     */
    public void setBean(Class<?> clazz, String beanId, String... paramBeanIds) {
        //1. 组装构造方法所需要的参数值
        Object[] paramValues = new Object[paramBeanIds.length];
        for (int i = 0; i < paramBeanIds.length; i++) {
            paramValues[i] = beans.get(paramBeanIds[i]);
        }
        //2. 调用构造方法实例化bean
        Object bean = null;
        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean = constructor.newInstance(paramValues);
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }
        if (bean == null) {
            throw new RuntimeException("找不到合适的构造方法去实例化bean");
        }
        //3. 将实例化的bean放入beans
        beans.put(beanId, bean);
    }
}
