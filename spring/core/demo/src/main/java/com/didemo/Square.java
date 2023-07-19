package com.didemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope("prototype")
@Component
public class Square implements Shape{

    @Autowired
    private Environment environment;

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

    @PostConstruct
    public  void  afterInit(){
        System.out.println("Square -afterinit, side="+side);
        int fetchedSide=environment.getProperty("square.side",Integer.class);
        System.out.println("feftched side using environment="+fetchedSide);
    }

    @PreDestroy
    public void  beforeRemoved(){
        System.out.println("Square-inside before removed");
    }



}
