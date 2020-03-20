package com.hqf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Bean {
    private AnotherBean anotherBean1;
    private AnotherBean anotherBean2;

    @Autowired
    private AnotherBean anotherBean3;

    private List<String> stringList;
    private Map<String, Integer> map;

    public Map<String, Integer> getMap() {
        return map;
    }

    @Autowired
    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public List<String> getStringList() {
        return stringList;
    }

    @Autowired
//    @Qualifier("stringList")
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    @Autowired
    public Bean(AnotherBean anotherBean1, AnotherBean anotherBean3) {
        this.anotherBean1 = anotherBean1;
        this.anotherBean3 = anotherBean3;
    }

    @Autowired
    public void setAnotherBean2(AnotherBean anotherBean2) {
        this.anotherBean2 = anotherBean2;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "anotherBean1=" + anotherBean1 +
                ", anotherBean2=" + anotherBean2 +
                ", anotherBean3=" + anotherBean3 +
                '}';
    }
}
