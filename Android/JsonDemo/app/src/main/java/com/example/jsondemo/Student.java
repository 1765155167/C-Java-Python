package com.example.jsondemo;

public class Student {
    private String name;
    private int age;
    private Scored scored;

    public Student(String name, int age, Scored scored) {
        this.name = name;
        this.age = age;
        this.scored = scored;
    }
    public Scored getScored() {
        return scored;
    }
    public void setScored(Scored scored) {
        this.scored = scored;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return  this.age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
