package com.didemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Square implements Shape{
    @Value("${square.side}")
    private int side;
    public Square(){
    }
    public Square(int side){
        this.side=side;
    }

    @Override
    public double area(){
        return side*side;
    }

}
