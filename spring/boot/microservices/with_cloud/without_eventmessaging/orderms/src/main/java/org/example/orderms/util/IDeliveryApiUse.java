package org.example.orderms.util;

import org.example.orderms.dto.OrderDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("deliveryms")
public interface IDeliveryApiUse {

    @PostMapping("/deliveries")
    void startDelivery(OrderDetails orderDetails);
}
