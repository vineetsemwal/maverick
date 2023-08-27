package org.example.registry.controllers;

import org.example.registry.dtos.AddUser;
import org.example.registry.dtos.AppUserDetails;
import org.example.registry.dtos.LoginRequest;
import org.example.registry.service.IUserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class AppController {

    private IUserService service;

    public AppController(IUserService service){
        this.service=service;
    }

    @GetMapping("/success")
    public String successfulLogin(){
        return "You are successfully logged in";
    }

    @PostMapping("/user/login")
    public String createToken(@RequestBody LoginRequest loginRequest){
        System.out.println("***inside create token");
        return   service.generateTokenAfterCredentialsCheck(loginRequest);
    }

    @PostMapping("/user/registeration")
    public AppUserDetails createUser(@RequestBody AddUser requestData){
        return service.registerUser(requestData);
    }

    @GetMapping("/a/user/retrieve/{username}")
    public Mono<AppUserDetails> fetchUser(@PathVariable String username){
        return service.findUserDetailsByUsername(username);
    }

}
