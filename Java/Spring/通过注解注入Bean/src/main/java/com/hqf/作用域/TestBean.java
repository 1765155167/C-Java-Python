package com.hqf.作用域;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bean3")
@Scope("singleton")//作用域单例模式
public class TestBean {

}
