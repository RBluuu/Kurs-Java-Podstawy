package com.java.course.com.lesson82.threads;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = () ->{
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

    }
}
