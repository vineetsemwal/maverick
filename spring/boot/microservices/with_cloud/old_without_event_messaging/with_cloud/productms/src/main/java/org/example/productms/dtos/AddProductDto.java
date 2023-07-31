package org.example.productms.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class AddProductDto {
    @Length(min=2,max=10)
    @NotBlank
    private String name;
    @Min(0)
    private double price;

    public AddProductDto(String name, double price){
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AddProductDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
