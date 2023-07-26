package org.example.service;

import org.example.dao.ICustomerRepository;
import org.example.dtos.AddCustomerRequest;
import org.example.dtos.BuyRequest;
import org.example.dtos.CustomerDetails;
import org.example.entities.Customer;
import org.example.exceptions.CustomerNotFoundException;
import org.example.util.CustomerUtil;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService{

    private ICustomerRepository repo;
    private CustomerUtil customerUtil;

    public CustomerServiceImpl(ICustomerRepository repo, CustomerUtil util){
        this.repo=repo;
        this.customerUtil=util;
    }

    @Override
    public CustomerDetails register(AddCustomerRequest request) {
        Customer customer=new Customer();
        customer.setName(request.getName());
        customer=repo.save(customer);
        CustomerDetails desired=customerUtil.toCustomerDetails(customer);
        return desired;
    }

    @Override
    public CustomerDetails findById(long id) throws CustomerNotFoundException{
        Customer customer= repo.findById(id)
                .orElseThrow(()->new CustomerNotFoundException("customer not found"));
         return customerUtil.toCustomerDetails(customer);
    }

    @Override
    public CustomerDetails buy(BuyRequest request) {
        return null;
    }
}
