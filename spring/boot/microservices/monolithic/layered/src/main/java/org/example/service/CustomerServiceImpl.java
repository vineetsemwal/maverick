package org.example.service;

import org.example.dao.ICustomerRepository;
import org.example.dao.IProductDao;
import org.example.dtos.AddCustomerRequest;
import org.example.dtos.BuyRequest;
import org.example.dtos.CustomerDetails;
import org.example.entities.Customer;
import org.example.entities.Product;
import org.example.exceptions.CustomerNotFoundException;
import org.example.exceptions.ProductNotFoundException;
import org.example.util.CustomerUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private ICustomerRepository customerRepo;
    private CustomerUtil customerUtil;

    private IProductDao productRepo;

    public CustomerServiceImpl(ICustomerRepository customerRepo, CustomerUtil util, IProductDao producRepo) {
        this.customerRepo = customerRepo;
        this.customerUtil = util;
        this.productRepo = producRepo;

    }

    @Override
    public CustomerDetails register(AddCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer = customerRepo.save(customer);
        CustomerDetails desired = customerUtil.toCustomerDetails(customer);
        return desired;
    }

    @Override
    public CustomerDetails findCustomerDetailsById(long id) throws CustomerNotFoundException {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("customer not found"));
        return customerUtil.toCustomerDetails(customer);
    }

    public Customer findById(long id) throws CustomerNotFoundException{
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("customer not found"));
        return customer;
    }

    @Override
    public CustomerDetails buy(BuyRequest request) throws CustomerNotFoundException, ProductNotFoundException {
        Customer customer = findById(request.getCustomerId());
        Product product = productRepo.findById(request.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("product not found"));
        List<Product> products=customer.getBoughtProducts();
        if(products==null){
            products=new ArrayList<>();
            customer.setBoughtProducts(products);
        }
        products.add(product);
        CustomerDetails desired=customerUtil.toCustomerDetails(customer);
        return desired;
    }

}
