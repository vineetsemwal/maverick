package org.example.demo;

import org.example.demo.dtos.AddUser;
import org.example.demo.service.IUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(Main.class,args);
        IUserService service=context.getBean(IUserService.class);
        PasswordEncoder passwordEncoder=context.getBean(PasswordEncoder.class);
        Environment environment=context.getBean(Environment.class);
        String username=environment.getProperty("admin.username");
        String password=environment.getProperty("admin.password");
        String encodedPassword=passwordEncoder.encode(password);
        String email=environment.getProperty("admin.email");
        AddUser request=new AddUser();
        request.setUsername(username);
        request.setPassword(encodedPassword);
        request.setEmail(email);
        service.registerAdmin(request);

    }
}