package org.example.orderms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReduceProductUnitsRequest {
    private long productId;
    private int units;

}
