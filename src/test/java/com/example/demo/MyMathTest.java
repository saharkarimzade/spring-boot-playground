package com.example.demo;

import com.example.MyMath;
import org.junit.jupiter.api.*;


public class MyMathTest {
    MyMath myMath = new MyMath();

    // MyMath.sum
    // 1,2,3 => 6
    @Test
    public void sum_with3numbers() {
        System.out.println("Test1");
        Assertions.assertEquals(13, myMath.sum(new int[] { 3 ,2,8}));
    }

    @Test
    public void sum_with1number() {
        System.out.println("Test2");
        Assertions.assertEquals(3, myMath.sum(new int[] { 3 }));
    }


    @BeforeEach
    public void before() {
        System.out.println("Before");
    }

    @AfterEach
    public void after() {
        System.out.println("After");
    }

    @BeforeAll
    public static void beforeClass() {
        System.out.println("BeforeAll");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("After All");
    }


}