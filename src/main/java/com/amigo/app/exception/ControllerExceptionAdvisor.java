package com.amigo.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RequestPayloadException> handleApiException(MethodArgumentNotValidException e) {
        List<ErrorMessageEntry> messages = new ArrayList<>();
        e.getBindingResult(). getAllErrors().forEach(error -> {
            messages.add(ErrorMessageEntry.builder()
                    .fieldName(((FieldError) error).getField())
                    .message(error.getDefaultMessage())
                    .build());
        });

        return new ResponseEntity<>(RequestPayloadException.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .messages(messages)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CustomException> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(CustomException.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .message(e.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }
}
