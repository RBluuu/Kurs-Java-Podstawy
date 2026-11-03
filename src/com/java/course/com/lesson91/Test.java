package com.java.course.com.lesson91;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // Napisz metodę, która pobiera listę tablic intów i zwraca wszystkie liczby,
        // które zawierają przynajmniej dwie 2ki i przynajmniej 2 5tki.

        ////2. Zmień metodę tak, aby zwracała liczby, które mają łącznie przynajmniej 3 cyfry 2 lub 5.

        List<int[]> tablice = List.of(
                new int[]{22,55,33,666,2222255,54},
                new int[]{44,22,55,66,5522,88,99}
        );
        List<Integer> wyniki = znajdzLiczby(tablice);

        System.out.println(wyniki);

    }

    public static List<Integer> znajdzLiczby(List<int[]> tablice) {
        List<Integer> liczby = new ArrayList<>();
        for(int[] tablica : tablice) {
            for( int liczba : tablica) {
                if (czyMaLiczby(liczba)) {
                    liczby.add(liczba);
                }
            }
        }
        return liczby;
    }

    private static boolean czyMaLiczby(int liczba) {
        int liczbaMusiBycDodatnia = Math.abs(liczba);
        int dwojki = 0;
        int piatki = 0;

        while (liczbaMusiBycDodatnia > 0) {
            int kopia = liczbaMusiBycDodatnia % 10;
            if (kopia == 2) {
                dwojki++;
            } else if (kopia == 5) {
                piatki++;
            }
            liczbaMusiBycDodatnia /= 10;
        }
        return (dwojki + piatki) >= 3;
    }
}


