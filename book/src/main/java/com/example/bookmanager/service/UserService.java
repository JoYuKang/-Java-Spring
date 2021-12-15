package com.example.bookmanager.service;

import com.example.bookmanager.domain.Gender;
import com.example.bookmanager.domain.User;
import com.example.bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class UserService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

        public User put1(){
        User user = new User();
        user.setName("재우");
        user.setEmail("wodn@naver.com");
        user.setGender(Gender.MALE);
        // void 한다면
        // userRepository.save(user);
        // 사용 가능

        return user;
    }
    @Transactional
    public void put2() {
        User user = new User();
        user.setName("재우");
        user.setEmail("wodn@naver.com");
        user.setGender(Gender.MALE);

        entityManager.persist(user);

        //entityManager.detach(user);
        // detach를 사용한다면 뒤에 변경이 이러난 값에 수정되지 않는다
        // 해당 값을 변경하려면 merge문을 상해야한다.

        //entityManager 뒤 이름 변경 과연 적용이 될것인가?
        // insert -> update 되어 이름이 변함
        user.setName("재우밥");
        // entityManager.merge(user);
        // detach 사용시 사용해야 값이 변경된다.
    }

}
