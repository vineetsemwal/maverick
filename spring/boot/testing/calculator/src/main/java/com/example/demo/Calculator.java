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

    public int multiply(int num1, int num2){
        return num1*num2;
    }

    public int multiplyBy10(int num){
        int result=multiply(num,10);
        return result;
    }


}
