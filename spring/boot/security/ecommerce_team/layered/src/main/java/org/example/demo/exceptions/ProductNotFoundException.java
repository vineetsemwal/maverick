package org.example.demo.exceptions;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String msg){
        super(msg);
    }
}
