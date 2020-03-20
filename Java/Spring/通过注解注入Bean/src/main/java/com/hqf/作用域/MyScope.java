package com.hqf.作用域;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

//自定义作用域
public class MyScope implements Scope {
    Map<String, Object> map1 = new ConcurrentHashMap<>();
    Map<String, Object> map2 = new ConcurrentHashMap<>();
    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        if (!map1.containsKey(s)) {
            Object o = objectFactory.getObject();
            map1.put(s, o);
            return o;
        }
        if (!map2.containsKey(s)) {
            Object o = objectFactory.getObject();
            map2.put(s, o);
            return o;
        }
        int index = new Random().nextInt(2);
        if (index == 0) {
            return map1.get(s);
        } else {
            return map2.get(s);
        }
    }

    @Override
    public Object remove(String s) {
        if (map2.containsKey(s)) {
            return map2.remove(s);
        }
        if (map1.containsKey(s)) {
            return map1.remove(s);
        }
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
