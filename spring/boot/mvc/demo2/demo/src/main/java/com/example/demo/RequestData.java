package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestData {

    private AppUser signedInAppUser;

    public AppUser getSignedInAppUser() {
        return signedInAppUser;
    }

    public void setSignedInAppUser(AppUser signedInAppUser) {
        this.signedInAppUser = signedInAppUser;
    }
}
