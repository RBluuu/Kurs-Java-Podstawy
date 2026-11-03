package com.java.course.com;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //napisz metode
        //public int findNPopularNumber(int[] array, int n) która z tablicy array znajduje Nty najpopularniejszy element.

        int[] array = {1,2,3,3,4,5,5,5,5};

        System.out.println(findNPopularNumber(array, 2));
    }

    public static int findNPopularNumber(int[] array, int Nty ){
        Map<Integer,Long> map = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(
                        number -> number,
                        Collectors.counting()
                ));
        return  map.entrySet()
                .stream()
                .filter(Objects::nonNull)
                .sorted((n1,n2) -> Long.compare(n2.getValue(), n1.getValue()))
                .skip(Nty-1)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Nie ma takiego elemtu"))
                .getKey();
    }
}
