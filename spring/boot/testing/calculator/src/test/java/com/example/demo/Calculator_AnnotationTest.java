package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class Calculator_AnnotationTest {

    @Mock
    Adder adder;

    @InjectMocks
    @Spy
    Calculator spy;

    @BeforeEach
    public void setup(){
        System.out.println("inside setup");
    }

    /**
     *  Scenario: inputs are positive
     *   inputs  1,2
     *   expected :3
     */
    @Test
    void sum_positive_nums() {
        when(adder.add(1,2)).thenReturn(3);
        System.out.println("inside app positive");
        int result= spy.sum(1,2);
        assertEquals(3,result);
        verify(adder).add(1,2);
    }

    /**
     *  Scenario: inputs are negative
     *   inputs  1,2
     *   expected :3
     */
    @Test
    void add_negative_nums() {
        System.out.println("inside add negative");
        when(adder.add(-3,-5)).thenReturn(-8);
        int result= spy.sum(-3,-5);
        assertEquals(-8,result);
        verify(adder).add(-3,-5);
    }

    @Test
    public void multiplyBy10(){
        doReturn(50).when(spy).multiply(5,10);
        int result=spy.multiplyBy10(5);
        assertEquals(50, result);
        verify(spy).multiply(5,10);
    }
}