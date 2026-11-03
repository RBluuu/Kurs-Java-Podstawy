package com.java.course.com.lesson78;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] tablica = {1, 2, 3, 4, 5, 6, 7, 8, 2, 8};

        System.out.println(najblzszyElementSredniej(tablica));


        System.out.println(Arrays.toString(unikalneElementy(tablica)));
    }

    public static int najblzszyElementSredniej(int[] tablica) {
        double srednia = 0;
        double suma = 0;
        for (int i =0; i < tablica.length; i++) {
            suma += tablica[i];
        }
        srednia = suma / tablica.length;
        int element = tablica[0];
        double roznica = Math.abs(tablica[0] - srednia);
        for (int i = 1; i < tablica.length; i++) {
            double roznica2 = Math.abs(tablica[i] - srednia);
            if (roznica2 < roznica) {
                roznica = roznica2;
                element = tablica[i];
            }
        }
        return element;
    }
    //21. Napisz metodę, która znajduje element najbliższy średniej wartości tablicy.

    //24. Napisz metodę, która zwraca tablicę zawierającą tylko unikalne elementy z oryginalnej tablicy. *
    //30. Napisz metodę, która sortuje tablicę rosnąco bez użycia wbudowanych metod sortowania. *
    public static int[] unikalneElementy(int[] tablica) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < tablica.length; i++) {
            set.add(tablica[i]);
        }
        int[] nowaTablica = new int[set.size()];
        int licznik = 0;
        for (Integer i : set) {
            nowaTablica[licznik] = i;
            licznik++;
        }
        return nowaTablica;
    }

}
