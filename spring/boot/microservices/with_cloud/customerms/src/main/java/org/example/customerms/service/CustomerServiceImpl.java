package org.example.customerms.service;

import org.example.customerms.dao.ICustomerRepository;
import org.example.customerms.dtos.AddCustomerRequest;
import org.example.customerms.dtos.BuyRequest;
import org.example.customerms.dtos.CustomerDetails;
import org.example.customerms.entities.Customer;
import org.example.customerms.exceptions.CustomerNotFoundException;
import org.example.customerms.util.CustomerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    private static final Logger Log= LoggerFactory.getLogger(CustomerServiceImpl.class);
    private ICustomerRepository customerRepo;
    private CustomerUtil customerUtil;


    public CustomerServiceImpl(ICustomerRepository customerRepo, CustomerUtil util) {
        this.customerRepo = customerRepo;
        this.customerUtil = util;
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
    public CustomerDetails buy(BuyRequest request) throws CustomerNotFoundException {
        Customer customer = findById(request.getCustomerId());
        List<Long> products=customer.getBoughtProducts();
        if(products==null){
            products=new ArrayList<>();
            customer.setBoughtProducts(products);
        }
        products.add(request.getProductId());
        customer=customerRepo.save(customer);
        CustomerDetails desired=customerUtil.toCustomerDetails(customer);
        return desired;
    }

}
