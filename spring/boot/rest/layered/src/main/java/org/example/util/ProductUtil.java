package org.example.util;

import org.example.dtos.ProductDetails;
import org.example.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductUtil {

    public ProductDetails convertToProductDetails(Product product) {
        ProductDetails desired=new ProductDetails();
        BeanUtils.copyProperties(product, desired);
        return desired;
    }

}
