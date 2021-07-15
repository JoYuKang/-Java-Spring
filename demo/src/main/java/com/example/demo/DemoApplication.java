package com.example.demo;

import com.example.demo.prac.Person;
import com.example.demo.prac.PersonRepository;
import com.example.demo.prac.PersonRequestDto;
import com.example.demo.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository, PersonService PersonService) {
        return (args) -> {
            personRepository.save(new Person("조유강", "인천광역시 남동구", "학생", 26));

            System.out.println("데이터 인쇄");
            List<Person> personList = personRepository.findAll();
            for (int i = 0; i < personList.size(); i++) {
                Person person = personList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getAddress());
                System.out.println(person.getJob());
                System.out.println(person.getAge());

            }

            //Course new_course = new Course("웹개발의 봄, Spring", "임민영");

            PersonRequestDto requestDto = new PersonRequestDto("홍루이젠", "인천광역시 남동구", "가게", 15);
            PersonService.update(1L, requestDto);
            personList = personRepository.findAll();
            for (int i = 0; i < personList.size(); i++) {
                Person person = personList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getAge());
                System.out.println(person.getAddress());
                System.out.println(person.getJob());

            }
            //삭제
            //courseRepository.deleteById(1L);

        };
    }
}
