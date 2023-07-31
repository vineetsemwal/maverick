package org.example.deliveryms;

import org.example.deliveryms.dto.OrderDetails;
import org.example.deliveryms.service.IDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@EnableDiscoveryClient
@SpringBootApplication
public class Main {
    @Autowired
    private IDeliveryService service;
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @Bean
    public Consumer<OrderDetails>createdOrder(){
        Consumer<OrderDetails>consumer= createdOrder->{
            service.startDelivery(createdOrder);
        };
        return consumer;
    }

}