package com.gltraining.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class Circle implements IShape {

    @Value("${circle.radius}")
    private int radius;

    public Circle(){}

    public Circle(int radius){
        this.radius=radius;
    }

    @Override
    public int area(){
        return (int)(3.14*radius*radius);
    }

    @PostConstruct
    public void  afterInit(){
        System.out.println("inside circle is already initialize="+radius);
    }



}
