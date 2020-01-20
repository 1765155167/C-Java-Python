package com.hqf.iot;

public class Led {

    private int id;
    private boolean on;

    public Led() {
        this.id = 0;
        this.on = true;
    }

    public Led(int id) {
        this.id = id;
        this.on = true;
    }

    public int getId() {
        return id;
    }

    public boolean isOn() {
        return on;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLed() {
        this.on = true;
    }

    public void closeLed() {
        this.on = false;
    }
}
