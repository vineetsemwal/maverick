package org.example.deliveryms.exception;

public class OrderNotFoundException extends Exception{
    public OrderNotFoundException(String msg){
        super(msg);
    }
}
