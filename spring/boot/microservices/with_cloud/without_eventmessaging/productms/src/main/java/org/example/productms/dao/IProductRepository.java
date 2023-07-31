package org.example.productms.dao;

import org.example.productms.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;


public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);

    List<Product> findByNameAndPrice(String name, double price);

    @Query("from Product where name=:name and price=:price")
    List<Product> findDesired(String name, double price);

    List<Product> findByIdIn(Collection<Long> ids);

}
