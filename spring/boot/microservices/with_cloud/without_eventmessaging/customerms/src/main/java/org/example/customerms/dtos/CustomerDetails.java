package org.example.customerms.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDetails {
    private long id;
    private String name;
    private double balance;
    private List<OrderDetails> orders;

}
