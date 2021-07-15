package com.example.demo.prac;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PersonRequestDto {
    private final String name;
    private final String address;
    private final String job;
    private final int age;

}

