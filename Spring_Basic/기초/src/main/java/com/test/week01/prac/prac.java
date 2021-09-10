package com.test.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class prac {
    public static void main(String[] args) {
        Course course = new Course();
        course.title = "웹개발의 봄, Spring";
        System.out.println(course.title);
        System.out.println(course.tutor);

        List<String> fruits = new ArrayList<>();
        fruits.add("감");
        fruits.add("배");
        fruits.add("감");
        fruits.add("딸기");
        fruits.add("수박");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("딸기");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("감");
        System.out.println(fruits);
        Course course2 = new Course();
        System.out.println(course.title);
        System.out.println(course.tutor);
        System.out.println(course.days);

        Course course3 = new Course("웹개발의 봄 스프링", "남병관", 35);
        System.out.println(course2.title);
        System.out.println(course2.tutor);
        System.out.println(course2.days);
    }
}
