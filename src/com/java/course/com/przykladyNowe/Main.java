package com.java.course.com.przykladyNowe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static Konto konto = new Konto();
    public static void main(String[] args) {
        ExecutorService wykonawca = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            wykonawca.execute(new dodajGrosz());
        }

        wykonawca.shutdown();

        while (!wykonawca.isTerminated()) {

        }

        System.out.println("Stan konta: " + konto.pobierzSaldo() + ".");
    }

    public static class dodajGrosz implements Runnable {
        public void run() {
            konto.wplata(1);
        }
    }
}
