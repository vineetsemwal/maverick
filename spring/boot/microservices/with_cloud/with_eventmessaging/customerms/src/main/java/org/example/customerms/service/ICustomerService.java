package org.example.customerms.service;

import org.example.customerms.dtos.AddCustomerRequest;
import org.example.customerms.dtos.BuyRequest;
import org.example.customerms.dtos.CustomerDetails;
import org.example.customerms.dtos.OrderDetails;
import org.example.customerms.exceptions.CustomerNotFoundException;
import org.example.customerms.exceptions.ProductNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
public interface ICustomerService {

    CustomerDetails register(@Valid AddCustomerRequest request);

    CustomerDetails findCustomerDetailsById(@Min(1) long id) throws CustomerNotFoundException;

    CustomerDetails buy(@Valid BuyRequest request) throws CustomerNotFoundException;

    void addOrderDetails(@Valid OrderDetails orderDetails) throws CustomerNotFoundException;

}
