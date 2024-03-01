package com.example.week01_test_skeletoncode.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Global
    API_ERROR_INTERNAL_SERVER(500, "G001", "서버 오류"),
    API_ERROR_INPUT_INVALID_VALUE(409, "G002", "잘못된 입력"),
    // 인출 에러
    API_ERROR_BALANCE_NOT_SUFFICIENT(400, "B001", "잔액이 부족합니다.")
    ;

    private final int status;
    private final String code;
    private final String message;
}
