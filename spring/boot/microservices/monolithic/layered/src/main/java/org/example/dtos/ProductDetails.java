package org.example.dtos;

import lombok.Data;
import org.example.entities.Product;

import javax.persistence.Column;

@Data
public class ProductDetails {
    private Long id;
    private String name;
    private double price;
}
