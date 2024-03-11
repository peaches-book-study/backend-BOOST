package com.peach.session.service;

import com.peach.session.api.dto.UserLoginRequestDto;
import com.peach.session.api.dto.UserResponseDto;
import com.peach.session.api.dto.UserSessionDto;
import com.peach.session.api.exception.SessionException;
import com.peach.session.entity.User;
import com.peach.session.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Base64;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private static final String SESSION_KEY = "SESSION";
    private static final String REDIS_SESSION_KEY = ":sessions:";

    @Value("${spring.session.redis.namespace}")
    private String namespace;

    private final StringRedisTemplate redisTemplate;

    public UserResponseDto login(UserLoginRequestDto loginRequestDto) {
        User loginUser = userRepository.login(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        return UserResponseDto.of(loginUser);
    }

    public UserSessionDto session(HttpServletRequest request) {
        String requestedSessionId = request.getRequestedSessionId();
        if (Boolean.FALSE.equals(redisTemplate.hasKey(namespace + REDIS_SESSION_KEY + requestedSessionId))) {
            log.warn("Session Cookie exist, but Session in Storage is not exist");
            throw new SessionException("세션 인증 실패");
        }
        return UserSessionDto.of(requestedSessionId);
    }
}
