package com.didemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        Shape shape1=context.getBean(Shape.class);
        Shape shape2=context.getBean(Shape.class);
        boolean isSame=shape1==shape2;
        Canvas canvas=context.getBean(Canvas.class);
        canvas.drawShape();
        System.out.println("shape1 and shape2 same="+isSame);
    }
}
