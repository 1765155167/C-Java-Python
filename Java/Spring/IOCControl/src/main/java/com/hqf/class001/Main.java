package com.hqf.class001;

import com.hqf.class001.car.Audi;
import com.hqf.class001.car.Buick;
import com.hqf.class001.humen.Human;
import com.hqf.class001.humen.PersonOne;
import com.hqf.class001.humen.PersonTwo;

public class Main {
    private static IOCContainer container = new IOCContainer();

    public static void before() {
        container.setBean(Audi.class, "audi");
        container.setBean(Buick.class, "buick");
        container.setBean(PersonOne.class, "personOne", "audi");
        container.setBean(PersonTwo.class, "personTwo", "buick");
    }

    public static void test() {
        Human human1 = (Human) container.getBean("personOne");
        human1.goHome();
        Human human2 = (Human) container.getBean("personTwo");
        human2.goHome();
    }

    public static void main(String[] args) {
        Main.before();
        Main.test();
    }
}
