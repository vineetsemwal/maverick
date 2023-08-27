package org.example.registry.exceptions;

public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException(String msg){
        super(msg);
    }
}
