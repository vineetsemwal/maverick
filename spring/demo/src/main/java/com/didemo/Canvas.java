package com.didemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Canvas {
    private Shape shape;
    /*
    public Canvas(Shape shape){
        this.shape =shape;
    }*/
    public Canvas(){
    }

    @Autowired
    public void setShape(Shape shape){
        this.shape=shape;
    }

    @PostConstruct
    public void afterInit(){
        System.out.println("inside Canvas after Init "+shape.getClass().getSimpleName());
    }

    public void drawShape(){
        double area=shape.area();
        System.out.println("drawing shape ="+area);
    }
}
