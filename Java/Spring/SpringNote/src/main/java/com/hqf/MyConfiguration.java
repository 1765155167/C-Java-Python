package com.hqf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MyConfiguration {
    @Bean(value = {"bean1", "bean2"})
    public Bean1 bean1() {
        return new Bean1();
    }
}