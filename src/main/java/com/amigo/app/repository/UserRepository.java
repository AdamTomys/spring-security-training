package com.amigo.app.repository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    //MOCK for LDAP for providing users details
    List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "admin@gmail.com",
                    "pass123",
                    Collections.singletonList((new SimpleGrantedAuthority("ROLE_ADMIN")))),
            new User(
                    "user@gmail.com",
                    "pass456",
                    Collections.singletonList((new SimpleGrantedAuthority("ROLE_USER"))))
    );

    public UserDetails findUserByEmail(String email) throws UsernameNotFoundException {
        return APPLICATION_USERS.stream()
                .filter(userDetails -> userDetails.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
