package org.example.productms;

import org.example.productms.dtos.CreateOrderRequest;
import org.example.productms.dtos.ReduceUnitsRequest;
import org.example.productms.exceptions.ProductNotFoundException;
import org.example.productms.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@EnableDiscoveryClient
@SpringBootApplication
public class Main {
    private static final Logger Log= LoggerFactory.getLogger(Main.class);
    private IProductService service;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public Consumer<CreateOrderRequest> reduceUnits()  {
        Consumer<CreateOrderRequest> consumer = (orderRequest) -> {
            try {
                ReduceUnitsRequest reduceUnitsRequest = new ReduceUnitsRequest(orderRequest.getProductId(), orderRequest.getUnits());
                service.reduceQuantity(reduceUnitsRequest);
                System.out.println("***asynchronous reduced quantity"+orderRequest);
            }catch (ProductNotFoundException e) {
                  Log.error("exception in reducing request",e);
            }
        };
        return consumer;

    }
}
