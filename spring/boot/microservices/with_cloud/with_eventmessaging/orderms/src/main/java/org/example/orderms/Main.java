package org.example.orderms;

import org.example.orderms.dto.CreateOrderRequest;
import org.example.orderms.dto.OrderDetails;
import org.example.orderms.service.IOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Main {
    @Autowired
    private IOrderService orderService;


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Function<CreateOrderRequest, OrderDetails> createOrder() throws Exception {
        Function<CreateOrderRequest, OrderDetails> function = (createOrderRequest) -> {
            OrderDetails details=new OrderDetails();
            details.setOrderId(1);
            BeanUtils.copyProperties(createOrderRequest,details);
            System.out.println("***order details");
            return details;
        };
        return function;
    }

}