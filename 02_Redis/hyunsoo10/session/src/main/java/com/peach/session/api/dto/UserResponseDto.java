package com.peach.session.api.dto;

import com.peach.session.entity.User;
import lombok.Data;

@Data
public class UserResponseDto {

    private String username;
    private String name;

    public UserResponseDto(User user) {
        this.username = user.getUsername();
        this.name = user.getName();
    }

    public static UserResponseDto of(User user) {
        return new UserResponseDto(user);
    }
}
