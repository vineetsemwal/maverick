package org.example.orderms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BuyRequest {
    private long customerId;
    private double orderTotal;

}
