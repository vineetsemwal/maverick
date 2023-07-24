package org.example.service;

import org.example.dtos.AddProductDto;
import org.example.dtos.ProductDetails;
import org.example.entities.Product;
import org.example.exceptions.ProductNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
public interface IProductService {
    List<Product> findAll();
    ProductDetails add(@Valid AddProductDto requestDto);

    ProductDetails findById(@Min(0) long id) throws ProductNotFoundException;

}
