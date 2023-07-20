package org.example.util;

import org.example.dtos.ProductDetails;
import org.example.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductUtil {

    public ProductDetails convertToProductDetails(Product product) {
        ProductDetails desired = new ProductDetails(product.getId(), product.getName(), product.getPrice());
        return desired;
    }

}
