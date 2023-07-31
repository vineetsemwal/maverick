package org.example.productms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddProductDto {
    @Length(min=2,max=10)
    @NotBlank
    private String name;
    @Min(0)
    private double price;

    private int units;

}
