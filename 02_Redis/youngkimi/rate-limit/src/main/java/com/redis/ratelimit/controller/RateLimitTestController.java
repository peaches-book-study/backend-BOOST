package com.redis.ratelimit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rate")
public class RateLimitTestController {

    final private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/{userId}")
    public ResponseEntity<?> ConnTest(int userId) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();

        valueOperations.set("PING", "PONG");
        String value = valueOperations.get("PING");

        return ResponseEntity.ok(value);
    }


}
