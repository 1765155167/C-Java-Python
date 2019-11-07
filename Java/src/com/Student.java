package com;

public class Student extends Person{
    private String id;
    private String school;

    Student(){}
    Student(String id, int age, String name, boolean sex, String address,String school) {
        super(age,name,sex,address);
        this.school = school;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
    public void printInfo() {
        System.out.println("姓名：" + this.getName() +
                " 性别：" + (this.isSex() ? "男":"女") +
                " 年龄：" + this.getAge() +
                " 地址：" + this.getAddress() +
                " 学校：" + this.getSchool());
    }
}
