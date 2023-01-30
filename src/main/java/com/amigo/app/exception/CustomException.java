package com.amigo.app.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class CustomException {
    final HttpStatus httpStatus;
    final String message;
}
