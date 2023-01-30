package com.amigo.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    final Long id;
    @NotBlank(message = "Name is required")
    final String name;
    @NotBlank(message = "Password is required")
    final String password;

    @NotBlank(message = "Email is required")
    @Email
    final String email;
}
