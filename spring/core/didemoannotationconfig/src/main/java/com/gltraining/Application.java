package com.gltraining;

import com.gltraining.beans.Canvas;
import com.gltraining.beans.Circle;
import com.gltraining.beans.IShape;
import com.gltraining.beans.Square;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.stream.Stream;


public class Application {

    public static void main(String args[]){

        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");

        Canvas canvas1=context.getBean(Canvas.class);
        System.out.println("shape set in canvas="+canvas1.getShape().getClass().getSimpleName());
        canvas1.drawShape();
        System.out.println("***second canvas fetched  byname");
        Canvas canvas2=context.getBean("canvas", Canvas.class);
        canvas2.drawShape();

        if(canvas1==canvas2){
            System.out.println("references are holding same canvas object");
        }else{
            System.out.println("different objects");
        }


        context.close();
        System.out.println("***bye , application exiting");


    }

}
