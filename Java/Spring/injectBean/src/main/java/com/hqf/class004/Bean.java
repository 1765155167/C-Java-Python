package com.hqf.class004;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Bean {
    private AnotherBean anotherBean;
    private String string;
    private AnotherBean anotherBean1;
    private String string1;
    private List<String> stringList;
    private List<AnotherBean> anotherBeanList;
    private Map<String, AnotherBean> stringAnotherBeanMap;
    private Map<AnotherBean, String> anotherBeanStringMap;
    private Set<String> stringSet;
    private Set<AnotherBean> anotherBeanSet;
    private Properties properties;
    private AnotherBean anotherBean2;

    public AnotherBean getAnotherBean2() {
        return anotherBean2;
    }

    public void setAnotherBean2(AnotherBean anotherBean2) {
        this.anotherBean2 = anotherBean2;
    }

    public AnotherBean getAnotherBean1() {
        return anotherBean1;
    }

    public void setAnotherBean1(AnotherBean anotherBean1) {
        this.anotherBean1 = anotherBean1;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public Bean(AnotherBean anotherBean, String string) {
        this.anotherBean = anotherBean;
        this.string = string;
    }

    public AnotherBean getAnotherBean() {
        return anotherBean;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<AnotherBean> getAnotherBeanList() {
        return anotherBeanList;
    }

    public void setAnotherBeanList(List<AnotherBean> anotherBeanList) {
        this.anotherBeanList = anotherBeanList;
    }

    public Map<String, AnotherBean> getStringAnotherBeanMap() {
        return stringAnotherBeanMap;
    }

    public void setStringAnotherBeanMap(Map<String, AnotherBean> stringAnotherBeanMap) {
        this.stringAnotherBeanMap = stringAnotherBeanMap;
    }

    public Map<AnotherBean, String> getAnotherBeanStringMap() {
        return anotherBeanStringMap;
    }

    public void setAnotherBeanStringMap(Map<AnotherBean, String> anotherBeanStringMap) {
        this.anotherBeanStringMap = anotherBeanStringMap;
    }

    public Set<String> getStringSet() {
        return stringSet;
    }

    public void setStringSet(Set<String> stringSet) {
        this.stringSet = stringSet;
    }

    public Set<AnotherBean> getAnotherBeanSet() {
        return anotherBeanSet;
    }

    public void setAnotherBeanSet(Set<AnotherBean> anotherBeanSet) {
        this.anotherBeanSet = anotherBeanSet;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getString() {
        return string;
    }

    public void setAnotherBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "anotherBean=" + anotherBean +
                ", string='" + string + '\'' +
                ", anotherBean1=" + anotherBean1 +
                ", string1='" + string1 + '\'' +
                ", stringList=" + stringList +
                ", anotherBeanList=" + anotherBeanList +
                ", stringAnotherBeanMap=" + stringAnotherBeanMap +
                ", anotherBeanStringMap=" + anotherBeanStringMap +
                ", stringSet=" + stringSet +
                ", anotherBeanSet=" + anotherBeanSet +
                ", properties=" + properties +
                '}';
    }
}
