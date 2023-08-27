package org.example.registry.exceptions;

public class IncorrectCredentialsException extends RuntimeException{
    public IncorrectCredentialsException(String msg){
        super(msg);
    }
}
