package org.example.demo.service;

import org.example.demo.dtos.AddCustomer;
import org.example.demo.dtos.CustomerDetails;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface ICustomerService {

    CustomerDetails register(@Valid AddCustomer requestData);
    CustomerDetails findByUserName(String username);

    List<CustomerDetails> findAll();

}
