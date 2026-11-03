package com.java.course.com.lesson82.functionalinterfaces;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> "Hello world";
        System.out.println(stringSupplier.get());

        Consumer<String> print = (s) -> System.out.println(s);
       print.accept("Test");

        Predicate<Double> isEven = x -> x % 2 == 0;
        Function<Integer,Integer> mnozenie = x -> 5 * 5;
        BiPredicate<Integer,Integer> mnozenie2 = (x,y) -> x > y;
    }
}

