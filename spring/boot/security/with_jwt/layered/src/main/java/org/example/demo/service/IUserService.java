package org.example.demo.service;

import org.example.demo.dtos.LoginRequest;
import org.springframework.validation.annotation.Validated;

@Validated
public interface IUserService {
    String generateTokenAfterCredentialsCheck(LoginRequest requestData);
}
