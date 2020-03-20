package com.hqf.作用域;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.hqf.作用域")
public class TestConfiguration {

    @Bean("bean1")
    @Scope("prototype") //多例模式
    public TestBean testBean1() {
        return new TestBean();
    }

    @Bean("bean2")
    @Scope("myScope") //使用自定义的作用域
    public TestBean testBean3() {
        return new TestBean();
    }

    @Bean(value = "testBean2", initMethod = "onInit", destroyMethod = "onDestroy")
    @Lazy
    public TestBean1 testBean11() {
        return new TestBean1();
    }

    @Bean
    public MyScope myScope() {
        return new MyScope();
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        var configure = new CustomScopeConfigurer();
        configure.addScope("myScope", myScope());
        return configure;
    }
}
