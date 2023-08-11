package org.example.demo.exceptions;

public class IncorrectCredentialsException extends RuntimeException{
    public IncorrectCredentialsException(String msg){
        super(msg);
    }
}
