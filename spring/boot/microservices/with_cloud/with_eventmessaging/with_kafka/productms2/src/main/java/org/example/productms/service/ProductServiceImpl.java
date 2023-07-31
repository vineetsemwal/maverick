package org.example.productms.service;

import org.example.productms.dao.IProductRepository;
import org.example.productms.dtos.AddProductDto;
import org.example.productms.dtos.ProductDetails;
import org.example.productms.dtos.ReduceUnitsRequest;
import org.example.productms.entities.Product;
import org.example.productms.exceptions.ProductNotFoundException;
import org.example.productms.util.ProductUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{
    private static final Logger Log= LoggerFactory.getLogger(ProductServiceImpl.class);
    private IProductRepository repo;
    private ProductUtil util;

    public ProductServiceImpl(IProductRepository repo, ProductUtil util){
        this.repo =repo;
        this.util=util;
    }

    @Transactional
    @Override
    public ProductDetails add(AddProductDto requestData) {
        Product product=new Product();
        util.setProduct(requestData,product);
        product= repo.save(product);
        ProductDetails desired=util.toProductDetails(product);
        return desired;
    }

    @Override
    public ProductDetails findProductDetailsById(long id) throws ProductNotFoundException{
        Product product= findProductById(id);
        ProductDetails desired=util.toProductDetails(product);
        return desired;
    }
    public Product findProductById(long id) throws ProductNotFoundException{
        Optional<Product> optional= repo.findById(id);
        if(!optional.isPresent()){
            throw new ProductNotFoundException("product not found for id="+id);
        }
        Product product= optional.get();
        return product;
    }

    @Override
    public List<ProductDetails> findByIdIn(Collection<Long> ids) {
        Log.info("inside finbyId of productservice, ids="+ids);
        List<Product>products= repo.findByIdIn(ids);
        return util.toProductDetailsList(products);
    }

    @Override
    public ProductDetails reduceQuantity(ReduceUnitsRequest request)throws ProductNotFoundException{
       Product product = findProductById(request.getProductId());
       product.setUnits(product.getUnits()-request.getUnits());
       product=repo.save(product);
       return util.toProductDetails(product);
    }

}
