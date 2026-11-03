package com.java.course.com.lesson91;

public class zadanie2 {
        public static void main(String[] args) {
            String s1 = "hello";
            String s2 = "hello";
            String s3 = "Hello";
            String s4 = new String("hello");

            System.out.println(s1.equals(s2)); // true
            System.out.println(s1.equals(s3)); // false
            System.out.println(s1.equals(s4)); // false
            System.out.println(s1 == s2); // true
            System.out.println(s1 == s3); // false
            System.out.println(s1 == s4); // false

            Integer i1 = 10;
            Integer i2 = 10;
            Integer i3 = 200;
            Integer i4 = 200;
            System.out.println();
            System.out.println(i1 == i2); // true
            System.out.println(i4 == i3); // false
        }
    }
