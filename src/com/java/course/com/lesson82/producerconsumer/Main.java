package com.java.course.com.lesson82.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Queue<String> queue = new LinkedList<>();
    static int capacity  = 5;

    public static void main(String[] args) {

        Runnable producerTask = ()->{
            for (int i = 0; i < capacity; i++) {
                synchronized (queue) {
                    queue.add("Hello");
                }
            }
        };

        Runnable consumerTask = () ->{
            for (int i = 0; i < capacity; i++) {
                synchronized (queue) {
                    String msg = queue.poll();
                    System.out.println("Received message: " + msg);
                }
            }
        };

        new Thread(producerTask).start();
        new Thread(consumerTask).start();
    }
}
