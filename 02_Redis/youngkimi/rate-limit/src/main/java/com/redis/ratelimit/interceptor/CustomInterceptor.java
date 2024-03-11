package com.redis.ratelimit.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.servlet.HandlerInterceptor;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class CustomInterceptor implements HandlerInterceptor {

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String endpoint = request.getRequestURI();

        long limit = 5L;

        Long count = valueOperations.increment(endpoint);
        redisTemplate.expire(endpoint, 5, TimeUnit.SECONDS);

        log.info("==================== CURRENT TIME ====================");
        log.info(String.valueOf(LocalDateTime.now()));
        log.info("Request Count : " + count);

        if (count != null && count > limit) {
            log.info(">>>>>>> TOO MANY REQUESTS >>>>>>>");
            return false;
        }
        if (count == null) {
            count = 1L;
            valueOperations.set(endpoint, String.valueOf(1), 5, TimeUnit.SECONDS);
        }

        return limit > count;
    }
}
