package com.hqf.class001.humen;

import com.hqf.class001.car.Car;

public class PersonOne extends HumanWithCar {

    public PersonOne(Car car) {
        super(car);
    }

    public void goHome() {
        car.start();
        car.turnLeft();
        car.turnRight();
        car.stop();
    }
}
