package org.example.orderms.util;

import org.example.orderms.dto.BuyRequest;
import org.example.orderms.dto.CreateOrderRequest;
import org.example.orderms.dto.OrderDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("customerms")
public interface ICustomerApiUse {
   @PutMapping("/customers/buy")
   void buy(BuyRequest request);
   @PutMapping("/customers/orders/add")
   void addOrder(OrderDetails order);
}
