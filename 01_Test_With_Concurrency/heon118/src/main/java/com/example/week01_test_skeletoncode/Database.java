package com.example.week01_test_skeletoncode;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class Database {
    private static final Map<Long, Account> db;

    static {
        db = new HashMap<>();
        db.put(1L, new Account(100000L, System.currentTimeMillis(), System.nanoTime()));
        db.put(2L, new Account(0L, System.currentTimeMillis(), System.nanoTime()));
        db.put(3L, new Account(7777777777L, System.currentTimeMillis(), System.nanoTime()));
        db.put(4L, new Account(22L, System.currentTimeMillis(), System.nanoTime()));
        db.put(5L, new Account(33333333333333L, System.currentTimeMillis(), System.nanoTime()));
        db.put(6L, new Account(888888L, System.currentTimeMillis(), System.nanoTime()));
        db.put(7L, new Account(110101010101L, System.currentTimeMillis(), System.nanoTime()));
        db.put(8L, new Account(6666666666666666666L, System.currentTimeMillis(), System.nanoTime()));
        db.put(9L, new Account(9999L, System.currentTimeMillis(), System.nanoTime()));
        db.put(10L, new Account(401401401401L, System.currentTimeMillis(), System.nanoTime()));
        db.put(11L, new Account(411411L, System.currentTimeMillis(), System.nanoTime()));
    }

    Account balance(Long id) throws InterruptedException {
//        Thread.sleep(new Random().nextLong() * 100L + 100);
        return db.getOrDefault(id, new Account(0L, System.currentTimeMillis(), System.nanoTime()));
    }

    Account balance(Long id, Long balance) throws InterruptedException {
//            Thread.sleep(new Random().nextLong() * 300L + 100);
        Account account = new Account(balance, System.currentTimeMillis(), System.nanoTime());
        db.put(id, account);
        return account;
    }
}
