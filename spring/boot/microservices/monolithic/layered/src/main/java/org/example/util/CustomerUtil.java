package org.example.util;

import org.example.dtos.CustomerDetails;
import org.example.dtos.ProductDetails;
import org.example.entities.Customer;
import org.example.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerUtil {
    private ProductUtil productUtil;

    public CustomerUtil(ProductUtil util){
        this.productUtil=util;
    }

    public CustomerDetails toCustomerDetails(Customer customer){
        CustomerDetails desired=new CustomerDetails();
        desired.setId(customer.getId());
        desired.setName(customer.getName());
        List<Product>products=customer.getBoughtProducts();
        if(products!=null) {
            List<ProductDetails> productsDto = productUtil.toProductDetailsList(products);
            desired.setBoughtProducts(productsDto);
        }
        return desired;
    }

}
