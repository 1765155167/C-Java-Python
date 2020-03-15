package com.hqf.class001.car;

public class Audi implements Car {
    public void start() {
        System.out.println("Audi.Start");
    }
    public void turnLeft() {
        System.out.println("Audi.Turn Left");
    }
    public void turnRight() {
        System.out.println("Audi.Turn Right");
    }
    public void stop() {
        System.out.println("Audi.Stop");
    }
}
