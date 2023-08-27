package org.example.registry.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomAuthenticationManager implements ReactiveAuthenticationManager {
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private UserDetailsService userService;

    @Autowired
    private ApplicationContext applicationContext;
    private PasswordEncoder passwordEncoder;

    public PasswordEncoder getPasswordEncoder(){
        if(passwordEncoder!=null){
            return passwordEncoder;
        }
        passwordEncoder=applicationContext.getBean(PasswordEncoder.class);
        return passwordEncoder;
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        System.out.println("*****inside authemanager");
        System.out.println("principal=" + authentication.getPrincipal());
        System.out.println("credentials=" + authentication.getCredentials());
        UserDetails user = userService.loadUserByUsername(authentication.getPrincipal().toString());
        if (user == null) {
            return Mono.empty();
        }
        String encodedPassword = getPasswordEncoder().encode(authentication.getCredentials().toString());
        if (encodedPassword == null || !encodedPassword.equals(user.getPassword())) {
            return Mono.error(new BadCredentialsException("bad credentials"));
        }
        System.out.println("user details=" + authentication.getDetails());
        System.out.println("authentication=" + authentication);
        return Mono.just(authentication);
    }
}

