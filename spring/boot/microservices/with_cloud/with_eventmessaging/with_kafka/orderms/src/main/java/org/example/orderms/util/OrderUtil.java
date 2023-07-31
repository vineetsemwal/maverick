package org.example.orderms.util;

import org.example.orderms.dto.CreateOrderRequest;
import org.example.orderms.dto.OrderDetails;
import org.example.orderms.entity.CreatedOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderUtil {
    public OrderDetails toDetails(CreatedOrder order){
        OrderDetails orderDetails=new OrderDetails();
        BeanUtils.copyProperties(order,orderDetails);
        orderDetails.setOrderId(order.getId());
        return orderDetails;
    }

    public List<OrderDetails>toDetailsList(Collection<CreatedOrder>orders){
        return orders.stream()
                .map(this::toDetails).collect(Collectors.toList());
    }

    public void populateOrder( CreateOrderRequest request,CreatedOrder order){
        BeanUtils.copyProperties(request,order);
    }

}
