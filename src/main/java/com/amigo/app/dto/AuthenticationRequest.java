package com.amigo.app.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    String email;
    String password;
}
