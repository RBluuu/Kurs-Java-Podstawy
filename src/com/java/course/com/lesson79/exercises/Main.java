package com.java.course.com.lesson79.exercises;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] tablica = {1, 10, 20, 55, 63, 999};
        System.out.println(sumaCyfr(tablica));
        System.out.println();

        String[] slowaZLiteraA = {"Radek","ala","alicja","ananas"};
        System.out.println(Arrays.toString(slowaZLiteraA));
        System.out.println();
        System.out.println("Slowo = " + slowoZNajwiekszaIlosciaA(slowaZLiteraA));
        System.out.println();
        System.out.println("Najwiekszy iloczyn = " + iloczynCyf(tablica));
        System.out.println();
        System.out.println("Najwieksza roznica = " + roznicaZLiczb(tablica));
    }
    //Napisz funkcje ktora znajdzie liczbe z najwiekssza suma cyfr
    //[1,10,20,55,63,999] -> 999 9+9=9 = 27

    //napisz funkcje ktora zwroic slowo ktore ma najwiecej literek 'a'

   public static String slowoZNajwiekszaIlosciaA(String[] tablicaWyrazow) {
        int max = -1;
        String wynik = "";
        for (String slowo : tablicaWyrazow) {
            int iloscA = 0;
            for (int j = 0; j < slowo.length(); j++) {
                if (slowo.charAt(j) == 'a') {
                    iloscA++;
                }
            }
            if (iloscA > max) {
                max = iloscA;
                wynik = slowo;
            }
        }
        return wynik;
    }


    public static int sumaCyfr(int[] tab) {
        int liczba = 0;
        int kolejnaLiczba = tab[0];

        for (int i = 0; i < tab.length; i++) {
            liczba = suma2Cyfr(tab[i]);
            if (liczba > kolejnaLiczba) {
                liczba = tab[i];
            }
        }
        return liczba;
    }

    public static int suma2Cyfr(int liczba) {
        int suma = 0;
        while (liczba > 0) {
            suma += liczba % 10;
            liczba = liczba / 10;
        }
        return suma;
    }

    //Napisz funkcję, która zwróci liczbę z tablicy, dla której iloczyn cyfr jest największy.
    public static int iloczynCyf(int[] tab) {
        int maxIloczyn = -1;
        int wynik = tab[0];

        for (int i = 0; i < tab.length; i++) {
            int liczba = tab[i];
            int iloczyn = 1;

            int temp = Math.abs(liczba); // żeby działało też dla liczb ujemnych

            // liczymy iloczyn cyfr
            while (temp > 0) {
                iloczyn *= temp % 10;
                temp /= 10;
            }

            // specjalny przypadek dla 0
            if (liczba == 0) {
                iloczyn = 0;
            }

            // sprawdzamy maksimum
            if (iloczyn > maxIloczyn) {
                maxIloczyn = iloczyn;
                wynik = liczba;
            }
        }

        return wynik;
    }

    //2. Napisz funkcję, która zwróci liczbę z tablicy, która ma największą różnicę między największą i najmniejszą cyfrą.
    public static int roznicaZLiczb(int[] tab) {
        int maxRoznica = -1;
        int wynik = tab[0];

        for (int i = 0; i < tab.length; i++) {
            int liczba = tab[i];
            int temp = Math.abs(liczba);
            int minCyfra = 9;
            int maxCyfra = 0;
            if (temp == 0) {
                minCyfra = 0;
                maxCyfra = 0;
            }
            while (temp > 0) {
                int cyfra = temp % 10;

                if (cyfra < minCyfra) {
                    minCyfra = cyfra;
                }
                if (cyfra > maxCyfra) {
                    maxCyfra = cyfra;
                }
                temp /= 10;
            }

            int roznica = maxCyfra - minCyfra;

            if (roznica > maxRoznica) {
                maxRoznica = roznica;
                wynik = liczba;
            }
        }
        return wynik;
    }

    //3. Napisz funkcję, która znajdzie dwie liczby z tablicy, których suma jest najbliższa zeru.


    
}
//1. Napisz funkcję, która zwróci liczbę z tablicy, dla której iloczyn cyfr jest największy.

//2. Napisz funkcję, która zwróci liczbę z tablicy, która ma największą różnicę między największą i najmniejszą cyfrą.

//3. Napisz funkcję, która znajdzie dwie liczby z tablicy, których suma jest najbliższa zeru.

//4. Napisz funkcję, która zwróci liczbę z tablicy, w której występuje najwięcej różnych cyfr.

//5. Napisz funkcję, która sprawdzi, czy w tablicy istnieje podtablica o długości k, której suma jest największa spośród wszystkich możliwych podtablic.

//6. Napisz funkcję, która zwróci długość najdłuższego rosnącego spójnego fragmentu tablicy.

//7. Napisz funkcję, która znajdzie element, który występuje w tablicy więcej niż połowę razy, a jeśli taki nie istnieje, zwróci odpowiednią informację.

//8. Napisz funkcję, która zwróci liczbę z tablicy, dla której suma cyfr parzystych jest większa od sumy cyfr nieparzystych o największą wartość.

//9. Napisz funkcję, która znajdzie indeks równowagi tablicy, czyli taki indeks, dla którego suma elementów po lewej stronie jest równa sumie elementów po prawej stronie.

//10. Napisz funkcję, która posortuje tablicę według sumy cyfr elementów rosnąco, a w przypadku remisu według wartości liczby malejąco.