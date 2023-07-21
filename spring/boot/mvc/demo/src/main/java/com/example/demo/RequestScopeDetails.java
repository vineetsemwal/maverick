package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class RequestScopeDetails {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
