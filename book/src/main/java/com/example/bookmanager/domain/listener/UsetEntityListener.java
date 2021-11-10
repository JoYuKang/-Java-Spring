package com.example.bookmanager.domain.listener;

import com.example.bookmanager.domain.User;
import com.example.bookmanager.domain.UserHistory;
import com.example.bookmanager.repository.UserHistoryRepository;
import com.example.bookmanager.support.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Component
public class UsetEntityListener {
//    @Autowired
//    private UserHistoryRepository userHistoryRepository;

    @PostPersist
    @PostUpdate
    public void prePersistAndUpdate(Object o ){

        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        User user = (User) o;
        UserHistory userHistory = new UserHistory();

        userHistory.setUserId(user.getId());

        userHistory.setEmail(user.getEmail());

        userHistory.setName(user.getName());

        userHistory.setGender(user.getGender());

        userHistory.setUser(user);

        userHistoryRepository.save(userHistory);

    }

}
