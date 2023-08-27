package org.example.registry;

import org.example.registry.dtos.AddUser;
import org.example.registry.service.IUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@EnableDiscoveryClient
@SpringBootApplication
public class Main {


    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(Main.class,args);
        IUserService service=context.getBean(IUserService.class);
        Environment environment=context.getBean(Environment.class);
        String username=environment.getProperty("admin.username");
        String password=environment.getProperty("admin.password");
        String email=environment.getProperty("admin.email");
        AddUser request=new AddUser();
        request.setUsername(username);
        request.setPassword(password);
        request.setEmail(email);
        service.registerAdmin(request);

    }
}