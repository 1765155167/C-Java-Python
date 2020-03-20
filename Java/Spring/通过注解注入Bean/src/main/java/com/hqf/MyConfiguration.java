package com.hqf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@ComponentScan("com.hqf")
public class MyConfiguration {

//    @Bean("stringList")
//    List<String> stringList() {
//        List<String> list = new ArrayList<>();
//        list.add("111");
//        list.add("222");
//        return list;
//    }
//    @Bean
//    public Map<String, Integer> integerMap() {
//        Map<String, Integer> map = new HashMap<>();
//        map.put("111", Integer.valueOf(111));
//        map.put("222", Integer.valueOf(222));
//        return map;
//    }

    @Bean("int1")
    public Integer integer1() {
        return Integer.valueOf(111);
    }

    @Bean("int2")
    public Integer integer2() {
        return Integer.valueOf(222);
    }

    @Bean
    @Order(10)
    public String string1() {
        return "333";
    }

    @Bean
    @Order(9)
    public String string2() {
        return "444";
    }
}
