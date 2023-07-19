package org.example.dao;

import org.example.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductDao extends JpaRepository<Product,Long> {

}
