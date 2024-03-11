package com.peach.session.api;

import com.peach.session.api.dto.ErrorMessageDto;
import com.peach.session.api.exception.SessionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(SessionException.class)
    public ResponseEntity<ErrorMessageDto> handleNotEnoughStockException(
            SessionException ex
    ) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(ex.getMessage());
        return new ResponseEntity<>(errorMessageDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
