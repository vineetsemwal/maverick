package org.example.customerms.dtos;

import lombok.Data;

@Data
public class AddCustomerRequest {
    private String name;
    private double balance;

}
