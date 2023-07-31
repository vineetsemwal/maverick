package org.example.customerms.service;

import org.example.customerms.dao.ICustomerRepository;
import org.example.customerms.dtos.AddCustomerRequest;
import org.example.customerms.dtos.BuyRequest;
import org.example.customerms.dtos.CustomerDetails;
import org.example.customerms.dtos.OrderDetails;
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
        customer.setBalance(request.getBalance());
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
        Log.info("inside buy customer id="+request.getCustomerId());
        Customer customer = findById(request.getCustomerId());
        customer.setBalance(customer.getBalance()-request.getOrderTotal());
        customer=customerRepo.save(customer);
        CustomerDetails desired=customerUtil.toCustomerDetails(customer);
        return desired;
    }

    @Override
    public void addOrderDetails(OrderDetails order)throws CustomerNotFoundException {
        Customer customer = findById(order.getCustomerId());
        List<Long>orders=customer.getOrders();
        if(orders==null){
            orders=new ArrayList<>();
            customer.setOrders(orders);
        }
        orders.add(order.getOrderId());
        customer=customerRepo.save(customer);
    }
}
