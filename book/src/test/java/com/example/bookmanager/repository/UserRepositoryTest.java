package com.example.bookmanager.repository;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

import com.example.bookmanager.domain.Gender;
import com.example.bookmanager.domain.User;
import com.example.bookmanager.domain.UserHistory;
import org.assertj.core.util.Lists;
import org.hibernate.criterion.Order;
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
    @Autowired
    private UserHistoryRepository userHistoryRepository;

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
        //System.out.println(userPage);
        //System.out.println(userPage.getTotalPages());
        System.out.println("확인");
        System.out.println("findByName " + userRepository.findByName("yukang",PageRequest.of(0,1,Sort.by(Sort.Order.desc("id")))).getContent());
    }
    @Test
    void exampleMatcher(){
        ExampleMatcher matcher = ExampleMatcher.matching()
                        .withIgnorePaths("name")
                                .withMatcher("email",endsWith());
        Example<User> example = Example.of(new User("na","naver.com"),matcher);


        userRepository.findAll(example).forEach(System.out::println);
    }
    @Test
    void select(){
        System.out.println(userRepository.findByName("yukang"));
    }


    @Test
    void findTopByNameOrderById(){
        System.out.println(userRepository.findTopByNameOrderByIdDesc("yukang"));
    }

    @Test
    void insertAndUpdate(){
        User user = new User();
        user.setName("kkkkkk");
        user.setEmail("kkkkk@naver.com");

        userRepository.save(user);
        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("klkklkl");

        userRepository.save(user2);
        userRepository.findAll().forEach(System.out::println);
    }
    @Test
    void enumTest(){
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);
        userRepository.save(user);
        //userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRowRecord().get("gender"));
    }
    @Test
    void listenerTest(){
        User user = new User();
        user.setEmail("jun@naver.com");
        user.setName("jun");
        userRepository.save(user);

        User user1 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user1.setName("juuuuun");
        userRepository.save(user1);
        userRepository.deleteById(4L);
        userRepository.findAll().forEach(System.out::println);
    }


    @Test
    void userRelationTest(){
        User user = new User();
        user.setName("jun");
        user.setEmail("jun@naver.com");
        user.setGender(Gender.MALE);
        userRepository.save(user);
        user.setName("daniel");
        userRepository.save(user);

        user.setEmail("daniel@naver.com");
        userRepository.save(user);
        //u serHistoryRepository.findAll().forEach(System.out::println);
//        List<UserHistory> result = userHistoryRepository.findByUserId(
//                userRepository.findByEmail("daniel@naver.com").getId());


        List<UserHistory> result = userRepository.findByEmail("daniel@naver.com").getUserHistories();
        result.forEach(System.out::println);
    }

}