package com.peach.session.repository;

import com.peach.session.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {

    static List<User> userList = new CopyOnWriteArrayList<>();
    static AtomicLong id = new AtomicLong(0L);

    @PostConstruct
    void initUser() {
        User user1 = User.builder().id(id.getAndAdd(1L)).username("hscho").password("1234").name("조현수").build();
        User user2 = User.builder().id(id.getAndAdd(1L)).username("yskim").password("1234").name("김영섭").build();
        User user3 = User.builder().id(id.getAndAdd(1L)).username("ypjeon").password("1234").name("전은평").build();
        User user4 = User.builder().id(id.getAndAdd(1L)).username("bhkim").password("1234").name("김병현").build();
        User user5 = User.builder().id(id.getAndAdd(1L)).username("shlee").password("1234").name("이승헌").build();

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
    }

    public User login(String username, String password) {
        return userList
                .stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("로그인 실패"));
    }

}
