package org.example.deliveryms.service;

import org.example.deliveryms.dto.DeliveryDetails;
import org.example.deliveryms.dto.OrderDetails;
import org.example.deliveryms.entity.Delivery;
import org.example.deliveryms.exception.OrderNotFoundException;
import org.example.deliveryms.repo.IDeliveryRepository;
import org.example.deliveryms.util.DeliveryUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryServiceImpl implements IDeliveryService{
    private IDeliveryRepository repo;
    private DeliveryUtil util;
    public DeliveryServiceImpl(IDeliveryRepository repo, DeliveryUtil util){
        this.repo=repo;
        this.util=util;
    }

    @Override
    public DeliveryDetails startDelivery(OrderDetails order) {
        Delivery delivery=new Delivery();
        BeanUtils.copyProperties(order,delivery);
        delivery=repo.save(delivery);
        DeliveryDetails desired= util.toDeliveryDetails(delivery);
        System.out.println("*****delivery started="+desired);
        return desired;
    }

    @Override
    public DeliveryDetails findDeliveryDetailsByOrderId(long orderId) throws OrderNotFoundException{
        Optional<Delivery>optional=repo.findDeliveryByOrderId(orderId);
        Delivery delivery=optional.orElseThrow(()->new OrderNotFoundException("order not found"));
        return util.toDeliveryDetails(delivery);
    }
}
