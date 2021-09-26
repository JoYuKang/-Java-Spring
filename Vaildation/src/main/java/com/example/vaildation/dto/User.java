package com.example.vaildation.dto;

import com.example.vaildation.annotaion.YearMonth;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class User {
    @NotBlank
    private String name;

    @Min(1)
    @Max(100)
    private int age;

    @Email
    private String email;

    public String getReqYearMonth() {
        return reqYearMonth;
    }

    public void setReqYearMonth(String reqYearMonth) {
        this.reqYearMonth = reqYearMonth;
    }

    @YearMonth
    private String reqYearMonth; //yyyyMM

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식이 맞지 않습니다. ex)01x-xxx(x)-xxxx")
    private String phoneNumber;

    @Valid // Valid 가 없으면 유효성 검삭가 안됨
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", car=" + cars +
                '}';
    }
}
