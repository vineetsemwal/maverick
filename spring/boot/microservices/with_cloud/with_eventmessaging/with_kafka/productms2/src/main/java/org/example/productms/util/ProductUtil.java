package org.example.productms.util;

import org.example.productms.dtos.AddProductDto;
import org.example.productms.dtos.ProductDetails;
import org.example.productms.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductUtil {

    public void setProduct(AddProductDto request,Product product){
        BeanUtils.copyProperties(request,product);
    }

    public ProductDetails toProductDetails(Product product) {
        ProductDetails desired=new ProductDetails();
        BeanUtils.copyProperties(product, desired);
        return desired;
    }
    public List<ProductDetails> toProductDetailsList(Collection<Product>products){
        return products.stream()
                .map(this::toProductDetails)
                .collect(Collectors.toList());
    }

}
