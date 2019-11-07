package com;

public class Test {
    public static void main(String[] args) {
        Student person = new Student();
        person.setSchool("郑州轻工业大学");
        person.setName("胡秋峰");
        person.setAddress("China");
        person.setSex(true);
        person.setAge(12);
        person.printInfo();
    }
}
