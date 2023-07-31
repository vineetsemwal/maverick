package org.example.orderms.controller;

import org.example.orderms.dto.CreateOrderRequest;
import org.example.orderms.dto.OrderDetails;
import org.example.orderms.service.IOrderService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orders")
@RestController
public class OrderController {

    private StreamBridge bridge;
    private IOrderService service;
    public OrderController(IOrderService service, StreamBridge bridge){
        this.service=service;
        this.bridge=bridge;
    }

    @PostMapping
    public OrderDetails createOrder(@RequestBody CreateOrderRequest request)throws Exception{
        OrderDetails desired= service.createOrder(request);
        bridge.send("createOrder-in-0",request);
        return desired;
    }

    @GetMapping("/by/id/{id}")
    public OrderDetails findOrderByOrderId(@PathVariable long id)throws Exception{
        return service.findByOrderId(id);
    }

    @GetMapping("/by/customer/{customerId}")
    public List<OrderDetails> findOrdersByCustomerId(@PathVariable long customerId) throws Exception{
        return service.findOrdersByCustomerId(customerId);
    }



}
