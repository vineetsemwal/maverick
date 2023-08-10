package org.example.demo.controllers;

import org.example.demo.dtos.LoginRequest;
import org.example.demo.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/tokens/create")
    public String createToken(@RequestBody LoginRequest loginRequest){
        String token=  service.generateTokenAfterCredentialsCheck(loginRequest);
        System.out.println("token="+token);
        return token;
    }

}
