package com.didemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.didemo")
@Configuration
public class JavaConfig {

    @Bean
    public Shape square(){
        return new Square(6);
    }
}
