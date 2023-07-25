package org.example.demo.util;

import org.example.demo.dtos.CustomerDetails;
import org.example.demo.entities.Customer;
import org.example.demo.entities.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerUtil {

    public CustomerDetails customerDetails(Customer customer) {
        User user = customer.getUser();
        CustomerDetails desired = new CustomerDetails();
        desired.setCustomerId(customer.getId());
        desired.setRoles(user.getRoles());
        desired.setUsername(user.getUsername());
        return desired;
    }

    public List<CustomerDetails> toDetailsList(Collection<Customer>customers){
      List<CustomerDetails>list=  customers.stream()
                .map(this::customerDetails)
                .collect(Collectors.toList());
      return list;
    }

}
