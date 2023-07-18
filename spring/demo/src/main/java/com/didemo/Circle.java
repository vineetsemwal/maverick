package com.didemo;

import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape{
    private double radius;
    public Circle(){}
    public Circle(double radius){
        this.radius=radius;
    }

    @Override
    public double area() {
        return 3.14*radius*radius;
    }
}
