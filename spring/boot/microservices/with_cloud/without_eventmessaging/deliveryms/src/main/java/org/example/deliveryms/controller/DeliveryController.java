package org.example.deliveryms.controller;

import org.example.deliveryms.dto.DeliveryDetails;
import org.example.deliveryms.dto.OrderDetails;
import org.example.deliveryms.service.IDeliveryService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/deliveries")
@RestController
public class DeliveryController {
    private IDeliveryService service;

    public DeliveryController(IDeliveryService service) {
        this.service = service;
    }

    @PostMapping
    public DeliveryDetails startDelivery(@RequestBody OrderDetails orderDetails) {
        return service.startDelivery(orderDetails);
    }

    @GetMapping("/by/order/id/{orderId}")
    public DeliveryDetails deliveryDetailsByOrderId(@PathVariable long orderId) throws Exception {
        return service.findDeliveryDetailsByOrderId(orderId);
    }

}
