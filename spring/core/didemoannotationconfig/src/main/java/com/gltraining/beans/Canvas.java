package com.gltraining.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Scope("prototype")
@Component
public class Canvas {


    private IShape shape;

    public IShape getShape() {
        return shape;
    }

    public Canvas() {
    }

    // @Qualifier("square")
    //@Autowired
    public Canvas(IShape shape) {
        this.shape = shape;
    }

    //@Qualifier("square")
    @Autowired
    public void setShape(IShape shape) {
        this.shape = shape;
    }


    public void drawShape() {
        System.out.println(shape.getClass().getSimpleName() + "getting drawn with area=" + shape.area());
    }

    @PostConstruct
    public void afterInit(){
        System.out.println("Inside canvas, afterinitialize, shape set= "+shape.getClass().getSimpleName());
    }



    @PreDestroy
    public void beforeDestroy(){
        System.out.println("Canvas object about to be removed from container");
    }


}
