package org.example.demo.service;

import org.example.demo.dao.IProductDao;
import org.example.demo.dtos.AddProductDto;
import org.example.demo.dtos.ProductDetails;
import org.example.demo.entities.Product;
import org.example.demo.exceptions.ProductNotFoundException;
import org.example.demo.util.ProductUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{
    private IProductDao dao;
    private ProductUtil util;

    public ProductServiceImpl(IProductDao dao, ProductUtil util){
        this.dao=dao;
        this.util=util;
    }

    @Transactional
    @Override
    public ProductDetails add(AddProductDto requestData) {
        Product product=new Product(requestData.getName(), requestData.getPrice());
        product=dao.save(product);
        ProductDetails desired=util.convertToProductDetails(product);
        return desired;
    }

    @Override
    public ProductDetails findById(long id) throws ProductNotFoundException{
        Optional<Product> optional=dao.findById(id);
        if(!optional.isPresent()){
            throw new ProductNotFoundException("product not found for id="+id);
        }
        Product product= optional.get();
        ProductDetails desired=util.convertToProductDetails(product);
        return desired;
    }
}
