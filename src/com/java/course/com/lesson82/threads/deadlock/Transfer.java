package com.java.course.com.lesson82.threads.deadlock;

public class Transfer implements Runnable {

    String accountFrom;
    String accountTo;

    public Transfer(String accountFrom, String accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    public static void transfer(String accountFrom, String accountTo) {

        Object firstLock;
        Object secondLock;

        if (accountFrom.compareTo(accountTo) < 0) {
            firstLock = accountFrom;
            secondLock = accountTo;
        } else {
            firstLock = accountTo;
            secondLock = accountFrom;
        }

        synchronized (firstLock) {
            System.out.println(Thread.currentThread().getName()
                    + " locked: " + firstLock);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (secondLock) {
                System.out.println(Thread.currentThread().getName()
                        + " locked: " + secondLock);

                System.out.println("Transfer from " + accountFrom + " to " + accountTo);
            }
        }
    }

    @Override
    public void run() {
        transfer(accountFrom, accountTo);
    }

    public static void main(String[] args) {
        String accountA = "Account A";
        String accountB = "Account B";

        Thread thread1 = new Thread(new Transfer(accountA, accountB), "Thread 1");
        Thread thread2 = new Thread(new Transfer(accountB, accountA), "Thread 2");

        thread1.start();
        thread2.start();
    }
}