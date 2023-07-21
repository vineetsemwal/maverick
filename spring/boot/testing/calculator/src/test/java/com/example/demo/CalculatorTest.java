package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    Adder adder;

    @BeforeEach
    public void setup(){
        adder= mock(Adder.class);
        calculator=new Calculator(adder);
        System.out.println("inside setup");
    }

    /**
     *  Scenario: inputs are positive
     *   inputs  1,2
     *   expected :3
     */
    @Test
    void add_positive_nums() {
        when(adder.add(1,2)).thenReturn(3);
        System.out.println("inside app positive");
        int result=calculator.sum(1,2);
        assertEquals(3,result);
        verify(adder).add(1,2);
    }

    /**
     *  Scenario: inputs are negative
     *   inputs  1,2
     *   expected :3
     *//*
    @Test
    void add_negative_nums() {
        System.out.println("inside add negative");
        int result=calculator.sum(-3,-5);
        assertEquals(-8,result);
    }*/
}