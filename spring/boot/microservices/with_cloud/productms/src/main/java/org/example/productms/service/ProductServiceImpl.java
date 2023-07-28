package org.example.productms.service;

import org.example.productms.dao.IProductDao;
import org.example.productms.dtos.AddProductDto;
import org.example.productms.dtos.ProductDetails;
import org.example.productms.entities.Product;
import org.example.productms.exceptions.ProductNotFoundException;
import org.example.productms.util.ProductUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
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

    @Override
    public List<ProductDetails> findByIdIn(Collection<Long> ids) {
        List<Product>products=dao.findByIdIn(ids);
        return util.toProductDetailsList(products);
    }
}
