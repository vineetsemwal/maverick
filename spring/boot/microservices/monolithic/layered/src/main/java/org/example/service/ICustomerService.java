package org.example.service;

import org.example.dtos.AddCustomerRequest;
import org.example.dtos.BuyRequest;
import org.example.dtos.CustomerDetails;
import org.example.exceptions.CustomerNotFoundException;
import org.example.exceptions.ProductNotFoundException;

public interface ICustomerService {

    CustomerDetails register(AddCustomerRequest request);

    CustomerDetails findCustomerDetailsById(long id) throws CustomerNotFoundException;
  CustomerDetails buy(BuyRequest request) throws CustomerNotFoundException, ProductNotFoundException ;

}
