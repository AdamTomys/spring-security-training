package com.amigo.app.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Data
public class RequestPayloadException {
    final HttpStatus httpStatus;
    final List<ErrorMessageEntry> messages;
}
