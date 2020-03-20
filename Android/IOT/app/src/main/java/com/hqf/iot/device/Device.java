package com.hqf.iot.device;

import com.google.gson.Gson;
import com.hqf.iot.service.MyMQTTService;
import com.hqf.iot.infoManager.InfoCheck;

import java.nio.charset.StandardCharsets;

public class Device {
    private String devType;
    protected int devId;
    protected boolean devFlag;

    public class DeviceType {
        public final static String LED = "Led";
        public final static String DOOR = "Door";
    }

    public Device(String devType, int devId, boolean devFlag) {
        this.devType = devType;
        this.devId = devId;
        this.devFlag = devFlag;
    }

    protected void setDevType(String devType) {
        this.devType = devType;
    }

    public String getDevType() {
        return this.devType;
    }

    public int getId() {
        return this.devId;
    }

    public boolean isOpen() {
        return this.devFlag;
    }

    public void setOpen(MyMQTTService myMQTTService) {
        if (this.devFlag != true) {
            this.devFlag = true;
        }
        publicMessage(myMQTTService);
    }

    public void setClose(MyMQTTService myMQTTService) {
        if (this.devFlag != false) {
            this.devFlag = false;
        }
        publicMessage(myMQTTService);
    }

    private void publicMessage(MyMQTTService myMQTTService) {
        Gson gson = new Gson();
        String json = gson.toJson(Device.this);
//        byte[] publicMessage = InfoCheck.infoEncryption(json.getBytes(), (byte)InfoCheck.ACK_NO_NEED, (byte)InfoCheck.INFO_STR);
//        myMQTTService.publishMessage(publicMessage);
        myMQTTService.publishMessage(json);
    }
}
