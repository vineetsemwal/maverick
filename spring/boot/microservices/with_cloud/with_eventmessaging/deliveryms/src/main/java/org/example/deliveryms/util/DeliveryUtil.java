package org.example.deliveryms.util;

import lombok.Data;
import org.example.deliveryms.dto.DeliveryDetails;
import org.example.deliveryms.entity.Delivery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Data
public class DeliveryUtil {
    public DeliveryDetails toDeliveryDetails(Delivery delivery){
        DeliveryDetails details=new DeliveryDetails();
        BeanUtils.copyProperties(delivery,details);
        return details;
    }
}
