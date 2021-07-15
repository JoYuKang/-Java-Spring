package com.example.demo.prac;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //getter  생략가능
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Person extends Timestamped {


    @Id  // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String job;

    @Column(nullable = false)
    private int age;

    public Person(PersonRequestDto requestDto) {
        // this 는 "이것" 이죠? 클래스 변수를 가리킵니다.
        this.name = requestDto.getName();
        this.address = requestDto.getAddress();
        this.job = requestDto.getJob();
        this.age = requestDto.getAge();
    }

    public Person(String name, String address,String job,int age) {
        this.name = name;
        this.address = address;
        this.job = job;
        this.age = age;

    }

    public void update(PersonRequestDto requestDto) {
        this.name = requestDto.getName();
        this.address = requestDto.getAddress();
        this.job = requestDto.getJob();
        this.age = requestDto.getAge();
    }

}
