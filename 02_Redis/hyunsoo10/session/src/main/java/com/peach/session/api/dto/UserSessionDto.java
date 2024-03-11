package com.peach.session.api.dto;

import com.peach.session.entity.User;
import lombok.Data;

@Data
public class UserSessionDto {

    private String sessionId;

    public UserSessionDto(String sessionId) {
        this.sessionId = sessionId;
    }

    public static UserSessionDto of(String sessionId) {
        return new UserSessionDto(sessionId);
    }
}
