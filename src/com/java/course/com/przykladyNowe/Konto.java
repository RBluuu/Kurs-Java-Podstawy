package com.java.course.com.przykladyNowe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Konto {
    private static Lock blokada = new ReentrantLock();
    private int saldo = 0;
    public int pobierzSaldo() {
        return saldo;
    }

    public void wplata(int kwota) {
        blokada.lock();
        try {
            int noweSaldo = saldo + kwota;
            Thread.sleep(5);
            saldo = noweSaldo;
        } catch (InterruptedException ex) {
        } finally {
            blokada.unlock();
        }
    }
}
