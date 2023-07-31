package org.example.customerms.util;

import org.example.customerms.dtos.CustomerDetails;
import org.example.customerms.dtos.ProductDetailsDTO;
import org.example.customerms.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerUtil {

    @Value("${product.baseUrl}")
    private String baseProductUrl;

    @Autowired
    private IProductFetcher productFetcher;

//    @Autowired
  //  public RestTemplate restTemplate;

    public CustomerDetails toCustomerDetails(Customer customer){
        CustomerDetails desired=new CustomerDetails();
        desired.setId(customer.getId());
        desired.setName(customer.getName());
        List<Long>productsId=customer.getBoughtProducts();
        if(productsId!=null) {
            List<ProductDetailsDTO> productsDto = fetchProducts(productsId);
            desired.setBoughtProducts(productsDto);
        }
        return desired;
    }

    public List<ProductDetailsDTO>fetchProducts(Collection<Long>productsId){
       List<ProductDetailsDTO>list= productFetcher.fetchProductsByIDs(productsId);
        return list;
    }

}
