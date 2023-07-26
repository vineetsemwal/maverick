package org.example.customerms.service;

import org.example.customerms.dtos.AddCustomerRequest;
import org.example.customerms.dtos.BuyRequest;
import org.example.customerms.dtos.CustomerDetails;
import org.example.customerms.exceptions.CustomerNotFoundException;
import org.example.customerms.exceptions.ProductNotFoundException;

public interface ICustomerService {

    CustomerDetails register(AddCustomerRequest request);

    CustomerDetails findCustomerDetailsById(long id) throws CustomerNotFoundException;
  CustomerDetails buy(BuyRequest request) throws CustomerNotFoundException;

}
