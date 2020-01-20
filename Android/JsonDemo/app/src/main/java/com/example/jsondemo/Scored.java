package com.example.jsondemo;

public class Scored {
    private double chinese;
    private double math;
    private double english;

    public Scored(double chinese, double math, double english) {
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getChinese() {
        return chinese;
    }

    public double getMath() {
        return math;
    }

    public double getEnglish() {
        return english;
    }
}
