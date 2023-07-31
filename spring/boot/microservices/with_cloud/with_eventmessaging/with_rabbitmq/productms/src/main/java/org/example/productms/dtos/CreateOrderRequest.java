package org.example.productms.dtos;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Data
public class CreateOrderRequest {
    @Min(1)
    private Long productId;
    @Min(1)
    private Long customerId;
    @NotBlank
    private String customerName;
    @NotBlank
    private String productName;
    @Min(0)
    private double productPrice;
    @Min(1)
    private int units;
}
