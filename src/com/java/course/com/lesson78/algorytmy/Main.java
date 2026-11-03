package com.java.course.com.lesson78.algorytmy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //https://www.bigocheatsheet.com/
        //30. Napisz metodę, która sortuje tablicę rosnąco bez użycia wbudowanych metod sortowania. *
        //Bubble Sort

        int[] tablica = {1, 9, 3, 4, 5, 6, 7, 8, 2, 8};
        System.out.println(Arrays.toString(posortowanaTablica(tablica)));
        System.out.println();


        System.out.println("Test nr1 = " + binarySearch(tablica, 6));
        System.out.println();

        System.out.println("Test nr2 = " + szukanieBinarne2(tablica, 6));
        System.out.println();

        System.out.println("Test nr3 = " + szukanieBinarne3(tablica, 6));
        System.out.println();
    }

    public static int[] posortowanaTablica(int[] tablica) {
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica.length; j++) {
                if (tablica[i] < tablica[j]) {
                    int liczba = tablica[i];
                    tablica[i] = tablica[j];
                    tablica[j] = liczba;
                }
            }
        }
        return tablica;
    }

    public static int binarySearch(int[] tablica, int szukanaLiczba) {
        int lewa = 0;
        int prawa = tablica.length - 1;
        while (lewa <= prawa) {
            int srodek = lewa + (prawa - lewa) / 2;
            if (tablica[srodek] == szukanaLiczba) {
                return srodek;
            }
            if (tablica[srodek] < szukanaLiczba) {
                lewa = srodek + 1;
            } else {
                prawa = srodek - 1;
            }
        }
        return -1;
    }


    public static int szukanieBinarne2(int[] tablica, int szukana) {
        int lewa = 0;
        int prawa = tablica.length - 1;
        while (lewa <= prawa) {
            int srodek = (prawa + lewa) / 2;
            if (tablica[srodek] == szukana) {
                return srodek;
            }
            if (tablica[srodek] < szukana) {
                lewa = srodek + 1;
            } else {
                prawa = srodek - 1;
            }
        }
        return -1;
    }


    public static int szukanieBinarne3(int[] tablica, int szukana) {
        int lewa = 0;
        int prawa = tablica.length - 1;
        while (lewa <= prawa) {
            int srodek = (lewa + prawa) / 2;
            if (tablica[srodek] == szukana) {
                return srodek;
            }
            if (tablica[srodek] > szukana) {
                prawa = srodek - 1;
            } else {
                lewa = srodek + 1;
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}


































//1. Zakoduj algorytm Binary Search
