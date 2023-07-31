package org.example.deliveryms.service;

import org.example.deliveryms.dto.DeliveryDetails;
import org.example.deliveryms.dto.OrderDetails;
import org.example.deliveryms.exception.OrderNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
public interface IDeliveryService {
    DeliveryDetails startDelivery(@Valid OrderDetails order);

    DeliveryDetails findDeliveryDetailsByOrderId(@Min(1) long orderId) throws OrderNotFoundException;
}
