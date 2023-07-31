package org.example.customerms.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class BuyRequest {
    private long customerId;
    private long productId;

}
