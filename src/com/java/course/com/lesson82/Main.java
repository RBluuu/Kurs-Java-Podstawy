package com.java.course.com.lesson82;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {321,2,3,212};
        //System.out.println(numbers[100]);

        try {
            new BufferedReader(new FileReader("test.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("!!!");
        }
        System.out.println(2/0);

        String hello = "Hello";
        //API - Application Programming Interface
        //String API
        System.out.println(hello.charAt(0));
        System.out.println(hello.length());

        //LIST API
        //SET API
    }
}
/*
ArrayIndexOutOfBounds
NullPointerException
IOException
FileNotFoundException
ArithmeticException
InterruptedException
 */
