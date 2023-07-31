package org.example.orderms.service;

import org.example.orderms.dto.BuyRequest;
import org.example.orderms.dto.CreateOrderRequest;
import org.example.orderms.dto.OrderDetails;
import org.example.orderms.dto.ReduceProductUnitsRequest;
import org.example.orderms.entity.CreatedOrder;
import org.example.orderms.exception.OrderNotFoundException;
import org.example.orderms.repository.IOrderRepository;
import org.example.orderms.util.ICustomerApiUse;
import org.example.orderms.util.IDeliveryApiUse;
import org.example.orderms.util.IProductApiUse;
import org.example.orderms.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements IOrderService{

    private IOrderRepository repo;
    private OrderUtil util;
    private StreamBridge bridge;

    private ICustomerApiUse customerApiUse;
    private IProductApiUse productApiUse;
    private IDeliveryApiUse deliveryApiUse;
    public OrderServiceImpl(IOrderRepository repo, OrderUtil util,
                            ICustomerApiUse customerApiUse,
                            IProductApiUse productApiUse,
                            IDeliveryApiUse deliveryApiUse,
                            StreamBridge bridge){
        this.repo=repo;
        this.util=util;
        this.customerApiUse=customerApiUse;
        this.bridge=bridge;
        this.productApiUse=productApiUse;
        this.deliveryApiUse=deliveryApiUse;
    }

    @Override
    public OrderDetails createOrder(CreateOrderRequest request) {
        CreatedOrder order=new CreatedOrder();
        util.populateOrder(request,order);
        double orderTotal= request.getUnits()* request.getProductPrice();
        order.setOrderTotal(orderTotal);
        order.setCreatedDateTime(LocalDateTime.now());
        /*
        ReduceProductUnitsRequest reduceProductUnitsRequest=new ReduceProductUnitsRequest(request.getProductId(),request.getUnits());
        productApiUse.reduceProductRequest(reduceProductUnitsRequest);
        */
        order=repo.save(order);
        OrderDetails desired= util.toDetails(order);
        return desired;
        /*
        customerApiUse.addOrder(desired);
        deliveryApiUse.startDelivery(desired);
        */

    }

    @Override
    public OrderDetails findByOrderId(Long orderId) throws OrderNotFoundException{
        Optional<CreatedOrder> optional=repo.findById(orderId);
        CreatedOrder order=optional.orElseThrow(()->new OrderNotFoundException("order not found"));
        return util.toDetails(order);
    }

    @Override
    public List<OrderDetails> findOrdersByCustomerId(long customerId) {
        List<CreatedOrder>orders=repo.findByCustomerId(customerId);
        return util.toDetailsList(orders);
    }
}
