package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Util {
    @Autowired
    private ApplicationContext context;

    public void logRequestDetails(){
        RequestScopeDetails request=context.getBean(RequestScopeDetails.class);
        System.out.println("request inside util="+request.getUser());
    }
}
