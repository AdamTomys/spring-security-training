package com.amigo.app.exception;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorMessageEntry {
    final String fieldName;
    final String message;
}
