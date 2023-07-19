package com.gltraining.beans;


public class Square implements IShape {

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

}
