package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {
    private static final Logger Log= LoggerFactory.getLogger(Calculator.class);

    public int add(int num1, int num2){
        Log.info("inside add of calculator");
        return num1+num2;
    }

}
