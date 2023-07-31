package org.example.customerms.dtos;

import lombok.*;

import javax.validation.constraints.Min;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BuyRequest {
    @Min(1)
    private long customerId;
    @Min(1)
    private double orderTotal;

}
