package org.example.util;

import org.example.dtos.ProductDetails;
import org.example.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductUtil {

    public ProductDetails convertToProductDetails(Product product) {
        ProductDetails desired=new ProductDetails();
        BeanUtils.copyProperties(product, desired);
        return desired;
    }
    public List<ProductDetails> toProductDetailsList(Collection<Product>products){
        return products.stream()
                .map(this::convertToProductDetails)
                .collect(Collectors.toList());
    }

}
