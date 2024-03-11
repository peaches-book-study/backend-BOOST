package com.redis.ratelimit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RateLimitApplicationTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void RedisConnTest() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();

        valueOperations.set("PING", "PONG");
        String value = valueOperations.get("PING");

        Assertions.assertEquals("PONG", value);
    }
}
