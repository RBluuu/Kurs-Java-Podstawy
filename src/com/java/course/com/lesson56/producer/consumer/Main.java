package com.java.course.com.lesson56.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    static Queue<String> queue = new LinkedList<>();
    static int messagesToProduce = 5;

    static int sizeProducer2 = 3;
    static int sizeProducer3 = 4;
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Runnable producerTask1 = () -> {
            for (int i = 0; i < messagesToProduce; i++) {
                String message = "Message #" + (i + 1);
                try {
                    Thread.sleep(random.nextInt(1000, 3000));
                    synchronized (queue) {
                        queue.add(message);
                        queue.notify();
                        System.out.println("Message added: " + message);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable producerTask2 = () -> {
            for (int i = 0; i < sizeProducer2; i++) {
                String message = "Message to Producer2#" + (i + 10);
                synchronized (queue) {
                    queue.add(message);
                    queue.notify();
                    System.out.println("Message added: " + message);
                }
            }
        };

        Runnable producerTask3 = () -> {
            for (int i = 0; i < sizeProducer3; i++) {
                String message = "Message to Producer3#" + (i + 100);
                {
                    lock.lock();
                    queue.add(message);
                    queue.notify();
                    System.out.println("Message added: " + message);
                    lock.unlock();
                }
            }
        };


        //Consumer

        Runnable consumerTask1 = () -> {
            int messagesToConsume = messagesToProduce;
            int counter = 0;
            while (messagesToConsume > 0) { //Aktywne Czekanie!!!
                counter++;
                synchronized (queue) {
                    if (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    String message = queue.poll();
                    System.out.println("Message Received: " + message);
                    System.out.println(counter);
                    messagesToConsume--;
                }
            }
        };

        Runnable consumerTask2 = () -> {
            int messagesToConsume = sizeProducer2;
            int counter = 0;
            while (messagesToConsume > 0) { //Aktywne Czekanie!!!
                counter++;
                synchronized (queue) {
                    if (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    String message = queue.poll();
                    System.out.println("Message Received from Producer3: " + message);
                    System.out.println(counter);
                    messagesToConsume--;
                }
            }
        };

        //SPRAWDZIC!!!

       /* Runnable consumerTask3 = () -> {
            int messagesToConsume = sizeProducer3;
            int counter = 0;
            while (messagesToConsume > 0) { //Aktywne Czekanie!!!
                lock.lock();
                try {
                    while (queue.isEmpty()) {
                        queue.wait();
                    }
                    String message = queue.poll();
                    System.out.println("Message Received from Producer3: " + message);
                    System.out.println(counter);
                    messagesToConsume--;
                } finally {
                    lock.unlock();
                }
            }
        };

        */


        new Thread(producerTask1).start();
        new Thread(consumerTask1).start();
        System.out.println();

        new Thread(producerTask2).start();
        new Thread(consumerTask2).start();
        System.out.println();

        new Thread(producerTask3).start();
       // new Thread(consumerTask3).start();


        /*
        1. Dodac jeszce 2 consumery i 2 producerys

       Stworzyc tylko 1 producerTask i tylkoConsumerTask
         */
    }
}
