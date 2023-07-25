package org.example.demo.service;

import org.example.demo.dtos.LoginRequest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface IUserService {
    String login(LoginRequest requestData);
}
