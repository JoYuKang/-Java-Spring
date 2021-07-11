package com.example.demo.prac;

public class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private String address;
    private String job;
    private int age;

    public Person() {

    }
    public Person(String name, String address,String job, int age) {
        // this 는 "이것" 이죠? 클래스 변수를 가리킵니다.
        this.name = name;
        this.address = address;
        this.job = job;
        this.age = age;
    }

}
