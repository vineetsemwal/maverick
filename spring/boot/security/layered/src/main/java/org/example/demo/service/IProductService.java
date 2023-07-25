package org.example.demo.service;

import org.example.demo.dtos.AddProductDto;
import org.example.demo.dtos.ProductDetails;
import org.example.demo.exceptions.ProductNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
public interface IProductService {
    ProductDetails add(@Valid AddProductDto requestDto);

    ProductDetails findById(@Min(0) long id) throws ProductNotFoundException;

}
