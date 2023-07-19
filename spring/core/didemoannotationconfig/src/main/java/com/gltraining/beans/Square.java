package com.gltraining.beans;

import com.gltraining.beans.IShape;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Square implements IShape {

    @Value("${square.side}")
    private int side;

    public int getSide(){
        return side;
    }
    public void setSide(int side){
        this.side=side;
    }

    public Square(){}
    public Square(int side) {
        this.side = side;
    }

    @Override
    public int area() {
        return side * side;
    }

    @PostConstruct
    public void  afterInit(){
        System.out.println("inside square, already initialized, side="+side);
    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("sqaure object about to be removed from container");
    }


}
