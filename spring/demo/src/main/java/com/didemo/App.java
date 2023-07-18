package com.didemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        System.out.println("before shape fetched");
        Shape shape1=context.getBean(Shape.class);
        Shape shape2=context.getBean(Shape.class);
        boolean isSame=shape1==shape2;
        Canvas canvas=context.getBean(Canvas.class);
        canvas.drawShape();
        System.out.println("shape1 and shape2 same="+isSame);
        System.out.println("before container close");
        context.close();
        System.out.println("after container close");
    }
}
