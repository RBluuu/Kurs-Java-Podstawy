package com.java.course.com.lesson91;

import java.util.ArrayList;
import java.util.List;

public class Zadanie1 {
        public static void main(String[] args) {
            List<Integer> numbers = new ArrayList<>(List.of(222, 222, 333, 333, 444, 555, 555, 666, 777));
            func(numbers);
            System.out.println(numbers);
        }

        public static void func(List<Integer> numbers) {
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) % 2 == 0) {
                    numbers.remove(numbers.get(i));
                    i--;
                }
            }
        }
    }

