package org.example.service;

import org.example.entities.Product;
import org.example.exceptions.ProductNotFoundException;

public interface IProductService {
    Product add(String name, double price);

    Product findById(long id) throws ProductNotFoundException;

}
