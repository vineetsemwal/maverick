package org.example.demo.controllers;

import org.example.demo.dtos.AddUser;
import org.example.demo.dtos.AppUserDetails;
import org.example.demo.dtos.LoginRequest;
import org.example.demo.service.IUserService;
import org.springframework.web.bind.annotation.*;

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
        String token=  service.generateTokenAfterCredentialsCheck(loginRequest);
        System.out.println("token="+token);
        return token;
    }

    @PostMapping("/user/registeration")
    public AppUserDetails createUser(@RequestBody AddUser requestData){
        return service.registerUser(requestData);
    }

    @GetMapping("/a/user/retrieve/{username}")
    public AppUserDetails fetchUser(@PathVariable String username){
        return service.findUserDetailsByUsername(username);
    }

}
