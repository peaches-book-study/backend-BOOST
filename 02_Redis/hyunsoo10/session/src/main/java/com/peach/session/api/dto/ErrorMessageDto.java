package com.peach.session.api.dto;

public class ErrorMessageDto {
    private String message;

    public ErrorMessageDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}