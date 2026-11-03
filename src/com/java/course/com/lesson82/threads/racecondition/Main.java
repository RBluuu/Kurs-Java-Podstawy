package com.java.course.com.lesson82.threads.racecondition;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger counter = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () ->{
            for (int i = 0; i < 100_000; i++) {
                counter.getAndIncrement();
            }
        };

        Thread t1 = new Thread(runnable);
        t1.start();
        Thread t2 = new Thread(runnable);
        t2.start();
        Thread t3 = new Thread(runnable);
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(counter);
    }
}
