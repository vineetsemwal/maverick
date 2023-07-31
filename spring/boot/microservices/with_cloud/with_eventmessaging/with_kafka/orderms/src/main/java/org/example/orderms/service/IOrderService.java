package org.example.orderms.service;


import lombok.NonNull;
import org.example.orderms.dto.CreateOrderRequest;
import org.example.orderms.dto.OrderDetails;
import org.example.orderms.exception.OrderNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface IOrderService {
OrderDetails createOrder(@Valid CreateOrderRequest request);

OrderDetails findByOrderId(@NotNull @Min(1) Long orderId)throws OrderNotFoundException;

List<OrderDetails>findOrdersByCustomerId(@Min(1) long customerId);

}
