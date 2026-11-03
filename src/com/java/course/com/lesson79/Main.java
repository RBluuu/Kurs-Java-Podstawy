package com.java.course.com.lesson79;

public class Main {

    public static void main(String[] args) {
        int[] tab = {1, 2, 5,2, 6, 7, 9};
        int[] tab2 = {9, 8, 7, 5, 4, 3};
        System.out.println(czyPosortowanaTablica(tab));
        System.out.println(czyPosortowanaTablica(tab2));

    }

    //napisz funkcje ktora sprawdzi czy podana tablica jest posortowana czy nie
    public static boolean czyPosortowanaTablica(int[] tablica) {
        boolean rosnaca = true;
        boolean malejaca = true;
        for (int i = 0; i < tablica.length - 1; i++) {
            if (tablica[i] > tablica[i + 1]) {
               malejaca =false;
            }
            if (tablica[i] < tablica[i + 1]) {
                rosnaca =  false;
            }
        }
        return rosnaca || malejaca;
    }
}
