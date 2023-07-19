package org.example.dao;

import org.example.entities.Product;

import java.util.Optional;

public interface IProductDao {

    void save(Product product);
    Optional<Product> findById(long id);

}
