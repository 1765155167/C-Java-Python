package com.hqf.class001.humen;

import com.hqf.class001.car.Car;

public class PersonTwo extends HumanWithCar {

    public PersonTwo(Car car) {
        super(car);
    }

    public void goHome() {
        car.start();
        car.stop();
    }
}
