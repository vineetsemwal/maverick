package org.example.service;

import org.example.dtos.AddProductDto;
import org.example.dtos.ProductDetails;
import org.example.entities.Product;
import org.example.exceptions.ProductNotFoundException;

public interface IProductService {
    ProductDetails add(AddProductDto requestDto);

    ProductDetails findById(long id) throws ProductNotFoundException;

}
