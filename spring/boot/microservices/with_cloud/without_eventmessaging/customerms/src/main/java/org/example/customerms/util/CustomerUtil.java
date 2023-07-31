package org.example.customerms.util;

import org.example.customerms.dtos.CustomerDetails;
import org.example.customerms.dtos.OrderDetails;
import org.example.customerms.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerUtil {
    private IOrderApiUse orderApiUse;

    public CustomerUtil(IOrderApiUse orderApiUse){
        this.orderApiUse=orderApiUse;
    }

    public CustomerDetails toCustomerDetails(Customer customer){
        CustomerDetails desired=new CustomerDetails();
        desired.setId(customer.getId());
        desired.setName(customer.getName());
        List<Long>ordersId=customer.getOrders();
        if(ordersId!=null) {
            List<OrderDetails>orders=orderApiUse.findOrdersByCustomer(customer.getId());
            desired.setOrders(orders);
        }
        desired.setBalance(customer.getBalance());
        return desired;
    }




}
