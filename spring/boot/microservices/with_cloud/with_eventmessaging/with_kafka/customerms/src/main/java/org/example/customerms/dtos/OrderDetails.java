package org.example.customerms.dtos;

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
    @Min(1)
    private int units;
    @Min(1)
    private long customerId;
    private long productId;

}
