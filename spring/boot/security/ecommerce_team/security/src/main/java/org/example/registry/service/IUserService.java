package org.example.registry.service;

import org.example.registry.dtos.AddUser;
import org.example.registry.dtos.AppUserDetails;
import org.example.registry.dtos.LoginRequest;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import reactor.core.publisher.Mono;

@Validated
public interface IUserService {
    AppUserDetails registerUser(@Valid AddUser requestData);
    AppUserDetails registerAdmin(@Valid AddUser requestData);
    Mono<AppUserDetails> findUserDetailsByUsername(@NotBlank String username);
    String generateTokenAfterCredentialsCheck(@Valid LoginRequest requestData);
}
