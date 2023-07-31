package org.example.orderms.controller;

import org.example.orderms.dto.CreateOrderRequest;
import org.example.orderms.dto.OrderDetails;
import org.example.orderms.service.IOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orders")
@RestController
public class OrderController {

    private IOrderService service;
    public OrderController(IOrderService service){
        this.service=service;
    }

    @PostMapping
    public OrderDetails createOrder(@RequestBody CreateOrderRequest request)throws Exception{
        return service.createOrder(request);
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
