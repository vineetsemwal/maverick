package com.didemo;

import org.springframework.stereotype.Component;

//@Component
public class Square implements Shape{
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
