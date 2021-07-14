package com.test02.week02;

import com.test02.week02.domain.Course;
import com.test02.week02.domain.CourseRepository;
import com.test02.week02.domain.CourseRequestDto;
import com.test02.week02.service.CourseService;
import lombok.Delegate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class Week02Application {
    public static void main(String[] args) {SpringApplication.run(Week02Application.class,args);

    }
    @Bean
    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
        return (args) -> {
            courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));

            System.out.println("데이터 인쇄");
            List<Course> courseList = courseRepository.findAll();
            for (int i=0; i<courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            //Course new_course = new Course("웹개발의 봄, Spring", "임민영");

            CourseRequestDto requestDto = new CourseRequestDto("웹개발의 봄, Spring", "임민영");
            courseService.update(1L, requestDto);
            courseList = courseRepository.findAll();
            for (int i=0; i<courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }
            //삭제
            //courseRepository.deleteById(1L);

        };
    }
};

