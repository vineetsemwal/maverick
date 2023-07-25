package org.example.demo;

import org.example.demo.dtos.AddAdmin;
import org.example.demo.service.IAdminService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(Main.class,args);
        IAdminService service=context.getBean(IAdminService.class);
        AddAdmin request=new AddAdmin("ramesh","1234");
        service.register(request);

    }
}