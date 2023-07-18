package com.didemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Canvas {
    private Shape shape;
    /*
    public Canvas(Shape shape){
        this.shape =shape;
    }*/
    public Canvas(){
    }

    @Qualifier("square")
    @Autowired
    public void setShape(Shape shape){
        this.shape=shape;
    }

    @PostConstruct
    public void afterInit(){
        System.out.println("inside Canvas after Init "+shape.getClass().getSimpleName());
    }
    @PreDestroy
    public  void beforeRemoved(){
        System.out.println("Inside canvas object, about to be removed");
    }

    public void drawShape(){
        double area=shape.area();
        System.out.println("drawing shape ="+area);
    }
}
