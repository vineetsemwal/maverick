package com.example.demo;

public class Calculator {

    Adder adder;

    public Calculator(Adder adder) {
        this.adder = adder;
    }

    public int sum(int num1, int num2){
        System.out.println("inside sum");
        int result=adder.add(num1,num2);
        return result;
    }

}
