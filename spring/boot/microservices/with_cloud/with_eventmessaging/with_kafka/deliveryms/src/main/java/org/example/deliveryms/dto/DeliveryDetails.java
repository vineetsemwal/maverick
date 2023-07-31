package org.example.deliveryms.dto;

import lombok.Data;

@Data
public class DeliveryDetails {
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
