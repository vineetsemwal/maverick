package org.example.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
public class CustomerDetails {
    private long id;
    private String name;
    private List<ProductDetails> boughtProducts;

}
