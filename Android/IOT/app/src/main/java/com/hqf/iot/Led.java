package com.hqf.iot;

import com.google.gson.Gson;

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

    public void setLed(MyMQTTService myMQTTService) {
        if(this.on != true) {
            this.on = true;
        }
        publicMessage(myMQTTService);
        //Student student2 = gson.fromJson(json, Student.class);
    }

    public void closeLed(MyMQTTService myMQTTService) {
        if(this.on != false) {
            this.on = false;
        }
        publicMessage(myMQTTService);
    }

    private void publicMessage(MyMQTTService myMQTTService) {
        Gson gson = new Gson();
        String json = gson.toJson(Led.this);
        myMQTTService.publishMessage(json);
    }
}
