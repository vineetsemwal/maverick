package org.example.orderms.dto;

import lombok.Data;

@Data
public class OrderDetails {
    private long orderId;
    private String productName;
    private double productPrice;
    private String customerName;
    private int units;
    private long customerId;
    private long productId;
}
