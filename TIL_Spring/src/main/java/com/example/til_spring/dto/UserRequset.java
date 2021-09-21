package com.example.til_spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequset {
    private String name;
    private String email;
    private int age;

    @JsonProperty("phone_number")
    private String PhoneNumber;

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserRequset() {

    }

    public UserRequset(String name, String email) {
        this.name = name;
        this.email = email;
        this.PhoneNumber = null;
    }

    public UserRequset(String name, String email, String PhoneNumber) {
        this.name = name;
        this.email = email;
        this.PhoneNumber = PhoneNumber;
    }

    @Override
    public String toString() {
        return "UserRequset{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                '}';
    }
}
