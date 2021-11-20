package com.example.bookmanager.service;

import com.example.bookmanager.domain.User;
import com.example.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void entityManagerTest() {
        System.out.println(entityManager.createQuery("select u from User u").getResultList());


    }

    @Test
    @Transactional
    void cacheFindTest() {

        System.out.println(userRepository.findById(1L).get());
        System.out.println(userRepository.findById(1L).get());
        System.out.println(userRepository.findById(1L).get());
        System.out.println("-----------------------------");
        System.out.println(userRepository.findByEmail("ykang9533@naver.com"));
        System.out.println(userRepository.findByEmail("ykang9533@naver.com"));
        System.out.println(userRepository.findByEmail("ykang9533@naver.com"));
        System.out.println(userRepository.findByEmail("ykang9533@naver.com"));

    }

    @Test
    @Transactional
    void cacheFindTest2() {
        User user = userRepository.findById(1L).get();
        user.setName("marrrrrrrrrtin");

        userRepository.save(user);

        System.out.println("------------------------");
        System.out.println(userRepository.findById(1L));
        user.setEmail("marrrrrrrrrtin@naver.com");

        userRepository.save(user);
        userRepository.flush();
        System.out.println(userRepository.findById(1L));
    }
}
