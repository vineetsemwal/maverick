package org.example.customerms;

import org.example.customerms.dtos.BuyRequest;
import org.example.customerms.dtos.CreateOrderRequest;
import org.example.customerms.exceptions.CustomerNotFoundException;
import org.example.customerms.service.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.function.Consumer;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Main {
    private static final Logger Log= LoggerFactory.getLogger(Main.class);
   @Autowired
    private ICustomerService service;
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Consumer<CreateOrderRequest> buy()  {
        Consumer<CreateOrderRequest> consumer = (orderRequest) -> {
            try {
                double orderTotal= orderRequest.getUnits()*orderRequest.getProductPrice();
                BuyRequest buyRequest = new BuyRequest(orderRequest.getProductId(), orderTotal);
                service.buy(buyRequest);
                System.out.println("***asynchronous buyrequest"+orderRequest);
            }catch (CustomerNotFoundException e) {
                Log.error("exception in buy request",e);
            }
        };
        return consumer;

    }

}