package org.example.deliveryms.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class OrderDetails {
    @Min(1)
     private long orderId;
    @NotBlank
    private String productName;
    @Min(0)
    private double productPrice;
    @NotBlank
    private String customerName;
    @Min(1)
    private int units;
    @Min(1)
    private long customerId;
    @Min(1)
    private long productId;

}
