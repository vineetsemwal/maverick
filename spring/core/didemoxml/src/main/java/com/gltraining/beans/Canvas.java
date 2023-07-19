package com.gltraining.beans;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Canvas {


    private IShape shape;

    public IShape getShape() {
        return shape;
    }

    public Canvas() {
    }

    public Canvas(IShape shape) {
        this.shape = shape;
    }

    public void setShape(IShape shape) {
        this.shape = shape;
    }


    public void drawShape() {
        System.out.println(shape.getClass().getSimpleName() + "getting drawn with area=" + shape.area());
    }

}
