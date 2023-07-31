package org.example.productms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReduceUnitsRequest {
    @Min(1)
    private long productId;
    @Min(1)
    private int units;

}
