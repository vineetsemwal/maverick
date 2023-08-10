package org.example.demo;

import org.example.demo.dtos.AddAdmin;
import org.example.demo.service.IAdminService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(Main.class,args);
        IAdminService service=context.getBean(IAdminService.class);
        PasswordEncoder passwordEncoder=context.getBean(PasswordEncoder.class);
        String encodedPassword=passwordEncoder.encode("1234");
        AddAdmin request=new AddAdmin("ramesh",encodedPassword);
        service.register(request);

    }
}