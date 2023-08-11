package org.example.demo.service;

import org.example.demo.dtos.AddUser;
import org.example.demo.dtos.AppUserDetails;
import org.example.demo.dtos.LoginRequest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Validated
public interface IUserService {
    AppUserDetails registerUser(@Valid AddUser requestData);
    AppUserDetails registerAdmin(@Valid AddUser requestData);
    AppUserDetails findUserDetailsByUsername(@NotBlank String username);
    String generateTokenAfterCredentialsCheck(@Valid LoginRequest requestData);
}
