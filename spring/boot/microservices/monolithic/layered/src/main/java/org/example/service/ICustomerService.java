package org.example.service;

import org.example.dtos.AddCustomerRequest;
import org.example.dtos.BuyRequest;
import org.example.dtos.CustomerDetails;
import org.example.exceptions.CustomerNotFoundException;

public interface ICustomerService {

    CustomerDetails register(AddCustomerRequest request);

    CustomerDetails findById(long id) throws CustomerNotFoundException;
    CustomerDetails buy(BuyRequest request);

}
