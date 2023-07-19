package org.example;

import org.example.frontend.FrontendUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
       // FrontendUI frontendUI=context.getBean(FrontendUI.class);
        System.out.println("frontend loaded and rendered");

    }
}