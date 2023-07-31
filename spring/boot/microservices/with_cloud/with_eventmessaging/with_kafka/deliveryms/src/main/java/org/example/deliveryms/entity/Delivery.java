package org.example.deliveryms.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.deliveryms.dto.OrderDetails;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@EqualsAndHashCode(of = "id")
@Data
@Entity
public class Delivery {
    @GeneratedValue
    @Id
    private Long id;
    private long orderId;
    private long customerId;
    private String customerName;
    private String productName;
    private double orderTotal;
    private int units;
    private double productPrice;
    private double latitude;
    private double longitude;

}
