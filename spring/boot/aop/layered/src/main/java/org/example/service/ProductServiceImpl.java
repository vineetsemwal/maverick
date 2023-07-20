package org.example.service;

import org.example.dao.IProductDao;
import org.example.entities.Product;
import org.example.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{
    private IProductDao dao;
    private long generatedId;
    public ProductServiceImpl(IProductDao dao){
        this.dao=dao;
    }
    public long generateId(){
        return ++generatedId;
    }
    @Override
    public Product add(String name, double price) {
        Product product=new Product(name,price);
        long newId=generateId();
        product.setId(newId);
        dao.save(product);
        return product;
    }

    @Override
    public Product findById(long id) throws ProductNotFoundException{
        Optional<Product> optional=dao.findById(id);
        if(!optional.isPresent()){
            throw new ProductNotFoundException("product not found for id="+id);
        }
        return optional.get();
    }
}
