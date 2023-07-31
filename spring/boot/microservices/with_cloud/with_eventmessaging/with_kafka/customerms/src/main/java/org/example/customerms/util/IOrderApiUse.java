package org.example.customerms.util;

import org.example.customerms.dtos.OrderDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("orderms")
public interface IOrderApiUse {

    @GetMapping("/orders/by/customer/{customerId}")
    List<OrderDetails>findOrdersByCustomer(@PathVariable long customerId);

}
