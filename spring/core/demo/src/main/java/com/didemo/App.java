package com.didemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        System.out.println("before shape fetched");
        // Shape shape1=context.getBean(Shape.class);
        // Shape shape2=context.getBean(Shape.class);
        Shape shape1 = context.getBean("square", Square.class);
        Shape shape2 = context.getBean(Square.class);
        boolean isSame=shape1==shape2;
        System.out.println("shape1 and shape2 same="+isSame);
        System.out.println("shape fetched=" + shape1.getClass().getSimpleName());
        Canvas canvas = context.getBean(Canvas.class);
        canvas.drawShape();
        System.out.println("shape1 and shape2 same="+isSame);
        System.out.println("before container close");
        Iterator<String>beansName =context.getBeanFactory().getBeanNamesIterator();
        while (beansName.hasNext()){
            System.out.println("bean="+beansName.next());
        }
        context.close();
        System.out.println("after container close");
    }
}
