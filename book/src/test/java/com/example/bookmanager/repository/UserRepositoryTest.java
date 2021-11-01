package com.example.bookmanager.repository;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

import com.example.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud(){
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        //userRepository.save(new User());
        users.forEach(System.out::println);
    }
    @Test
    void findOne(){
        User user = userRepository.findById(1L).orElse(null);
        //user.toString();
        System.out.println(user);
    }
    @Test
    void saveFlush(){
        userRepository.save(new User("new martin","korea@naver.com"));
        userRepository.flush();
        userRepository.findAll().forEach(System.out::println);
    }
    @Test
    void count(){
       long count = userRepository.count();
       System.out.println(count);
    }
    @Test
    void booleanCheck(){
        boolean check = userRepository.existsById(1L);
        System.out.println(check);
    }

    @Test
    void delete(){
        userRepository.deleteById(1L);
        userRepository.findAll().forEach(System.out::println);
    }
    @Test
    void selectDelete(){
        //or 연산을 사용하여 실행 횟수를 줄인다.
        userRepository.deleteAllInBatch(userRepository.findAllById(Lists.newArrayList(1L,3L)));
        userRepository.findAll().forEach(System.out::println);
    }
    @Test
    void paging(){
        Page<User> userPage = userRepository.findAll(PageRequest.of(1,3));
        System.out.println(userPage);
        System.out.println(userPage.getTotalPages());
    }
    @Test
    void exampleMatcher(){
        ExampleMatcher matcher = ExampleMatcher.matching()
                        .withIgnorePaths("name")
                                .withMatcher("email",endsWith());
        Example<User> example = Example.of(new User("na","naver.com"),matcher);


        userRepository.findAll(example).forEach(System.out::println);
    }

}