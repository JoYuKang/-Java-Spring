package com.test02.week02;

import com.test02.week02.domain.Course;
import com.test02.week02.domain.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Week02Application {

    public static void main(String[] args) {
        SpringApplication.run(Week02Application.class, args);
    }
    // Week02Application.java 의 main 함수 아래에 붙여주세요.
    @Bean
    public CommandLineRunner demo(CourseRepository repository) {
        return (args) -> {
            Course course1 = new Course("Spring", "조유강");

            repository.save(course1); //insert

            List<Course> coursesList = repository.findAll();

            //select
            for(int i = 0;i<coursesList.size();i++){
                Course c = coursesList.get(i);
                System.out.println(c.getTitle());
                System.out.println(c.getTutor());

            }
//            for (Course course : coursesList) {
//                System.out.println(course);
//            }


        };
    }
}
