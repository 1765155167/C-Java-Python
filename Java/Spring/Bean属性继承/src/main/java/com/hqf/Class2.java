package com.hqf;

public class Class2 extends ParentClass {
    private String attribute7;
    private String attribute8;
    private String attribute1;
    private String attribute2;
    private String attribute3;

    @Override
    public String getAttribute1() {
        return attribute1;
    }

    @Override
    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    @Override
    public String getAttribute2() {
        return attribute2;
    }

    @Override
    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    @Override
    public String getAttribute3() {
        return attribute3;
    }

    @Override
    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    @Override
    public String toString() {
        return "Class2{" +
                "attribute7='" + attribute7 + '\'' +
                ", attribute8='" + attribute8 + '\'' +
                ", attribute1='" + getAttribute1() + '\'' +
                ", attribute2='" + getAttribute2() + '\'' +
                ", attribute3='" + getAttribute3() + '\'' +
                '}';
    }
}
