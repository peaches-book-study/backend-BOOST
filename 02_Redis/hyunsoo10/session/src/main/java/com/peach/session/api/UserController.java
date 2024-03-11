package com.peach.session.api;

import com.peach.session.api.dto.UserLoginRequestDto;
import com.peach.session.api.dto.UserResponseDto;
import com.peach.session.api.dto.UserSessionDto;
import com.peach.session.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    private ResponseEntity<?> login(@RequestBody UserLoginRequestDto loginRequestDto, HttpServletRequest request) {

        UserResponseDto userResponseDto = userService.login(loginRequestDto);

        //세션 정보 불러오기 및 설정
        HttpSession session = request.getSession();
        session.setAttribute("username", loginRequestDto.getUsername());
        session.setMaxInactiveInterval(3600);

        return ResponseEntity.ok().body(userResponseDto);

    }

    @GetMapping("/session")
    private ResponseEntity<?> sessionCheck(HttpServletRequest request) {

        UserSessionDto session = userService.session(request);
        return ResponseEntity.ok().body(session);

    }
}
