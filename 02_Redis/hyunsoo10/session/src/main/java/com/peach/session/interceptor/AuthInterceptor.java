package com.peach.session.interceptor;

import com.peach.session.api.exception.SessionException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Base64;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private static final String REDIS_SESSION_KEY = ":sessions:";

    @Value("${spring.session.redis.namespace}")
    private String namespace;

    private final StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        final String requestedSessionId = request.getRequestedSessionId();
        System.out.println("requestedSessionId = " + requestedSessionId);
        if (Boolean.FALSE.equals(redisTemplate.hasKey(namespace + REDIS_SESSION_KEY + requestedSessionId))) {
            log.warn("Session Cookie exist, but Session in Storage is not exist");
            throw new SessionException("세션 인증 실패");
        }
        return true;
    }
}
