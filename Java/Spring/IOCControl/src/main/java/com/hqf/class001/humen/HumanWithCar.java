package com.hqf.class001.humen;

import com.hqf.class001.car.Car;
//有车一族
public abstract class HumanWithCar implements Human {
    protected Car car;

    public HumanWithCar(Car car) {
        this.car = car;
    }

    public abstract void goHome();
}
