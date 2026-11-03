package com.java.course.com.przykladyNowe;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        //1 Stworz 5 elementowa tablice i wypelnij ja liczbami od 1 do 5
        System.out.println("Zadanie 1");
        int[] tablica1 = new int[5];
        for (int i = 1; i < 5; i++) {
            tablica1[i] = i + 1;
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(tablica1[i]);
        }
        System.out.println();

        //2 Stworz 1000 elementowa tablice i wypelnij ja liczbami od 1 do 1000
        System.out.println("Zadanie 2");
        int[] tablica2 = new int[1000];
        for (int i = 1; i < 1000; i++) {
            tablica2[i] = i + 1;
        }
        for (int i = 0; i < 1000; i++) {
            System.out.print(tablica2[i] + " ");
        }
        System.out.println();


        //3 Stworz 10 elementowa tablice i wypelnij ja liczbami od 10 do 1
        System.out.println("Zadanie 3");
        int[] tablica3 = new int[10];
        for (int i = 0; i < 10; i++) {
            tablica3[i] = 10 - i;
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(tablica3[i] + " ");
        }
        System.out.println();

        //4 Stworz 10 elementowa tablice i wypelnij ja liczbami parzystymi od 2 do 20
        System.out.println("Zadanie 4");
        int[] tablica4 = new int[10];
        for (int i = 0; i < 10; i++) {
            tablica4[i] = (i + 1) * 2;
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(tablica4[i] + " ");
        }
        System.out.println();


        //5 Stworz dowolna tablice i wypisz jej elementy, ale tylko te pod parzystymi indeksami
        System.out.println("Zadanie 5");
        int[] tablica5 = new int[10];
        for (int i = 0; i < 10; i++) {
            tablica5[i] = i + 1;
        }
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) {
                System.out.print(tablica5[i] + " ");
            }
        }
        System.out.println();


        //6 Stworz dwie tablice i wypisz tylko wspolne elementy
        System.out.println("Zadanie 6");
        int[] tablica6 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] tablica7 = {1, 2, 3, 4, 18, 21, 222, 223, 255};

        Set<Integer> wspolneElementy = new HashSet<>();

        for (int liczba : tablica6) {
            wspolneElementy.add(liczba);
        }
        System.out.println("Wspolne elementy = ");
        for (int liczba : tablica7) {
            if (wspolneElementy.contains(liczba)) {
                System.out.print(liczba + " ");
            }
        }
        System.out.println();

        System.out.println();
        //7 Stworz dwie tablice i wypisz tylko unikatowe elementy
        ArrayList<Integer> unikatoweElementy = new ArrayList<>();
        System.out.println("Zadanie 7 ");
        System.out.println("Unikatowe elementy");
        for (int liczba : tablica7) {
            if (!wspolneElementy.contains(liczba)) {
                System.out.print(liczba + " ");
            }
        }
        System.out.println();


        //8. Stwórz dwuwymiarową tablicę 3x3 i wypełnij ją liczbami od 1 do 9.
        System.out.println("Zadanie 8  ");
        System.out.println("Tablica 2 wymiarowa 3x3");
        int[][] tablica = new int[3][3];

        int liczba = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablica[i][j] = liczba;
                liczba++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablica[i][j] + " ");
            }
            System.out.println();
        }


        //9. Stwórz tablicę 5x5 i wypełnij ją wzorem szachownicy, używając 0 i 1.
        System.out.println("Zadanie 9  ");
        System.out.println("Tablica 2 wymiarowa 5x5");
        int[][] tablica10 = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if ((i + j) % 2 == 0) {
                    tablica10[i][j] = 0;
                } else {
                    tablica10[i][j] = 1;
                }

                System.out.print(tablica10[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


        //10. Stwórz tablicę zawierającą 5 różnych imion, a następnie wypisz je w odwrotnej kolejności.
        System.out.println("Zadanie 10");
        String[] imiona = {"radek", "wojtek", "piotr", "lukasz", "darek"};
        for (int i = imiona.length - 1; i >= 0; i--) {
            System.out.println(imiona[i]);
        }


        //11. Stwórz 10-elementową tablicę liczb całkowitych i wypisz ich sumę.
        System.out.println("Zadanie 11");
        int[] tablica11 = {1,2,3,4,5,6,7,8,9,10};
        int suma11 = 0;
        for (int i = 0; i< tablica11.length; i++) {
            suma11 += tablica11[i];
        }
        System.out.println(suma11);
        System.out.println();

        //12. Stwórz dwuwymiarową tablicę reprezentującą macierz 4x4 i wypisz jej przekątną.
        System.out.println("Zadanie 12:");
        int[][] tablica12 = new int[4][4];
        int liczba12 = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tablica12[i][j] = liczba12++;
            }
        }
        System.out.println("Przekątna główna:");
        for (int i = 0; i < 4; i++) {
            System.out.print(tablica12[i][i] + " ");
        }
        System.out.println();


        //13. Stwórz tablicę i wypełnij ją losowymi liczbami, a następnie znajdź największą i najmniejszą wartość.
        System.out.println("Zadanie 13");
        int[] tablica13 = {55,12,2,222,0,333,999};
        System.out.println("Najwieksza liczba = " + Arrays.stream(tablica13).max());
        System.out.println("Najmniejsza liczba = " + Arrays.stream(tablica13).min());
        System.out.println();


        //15. Stwórz 10-elementową tablicę liczb całkowitych i wypisz liczbę wystąpień każdej liczby
        System.out.println("Zadanie 15");
        int[] tablica14 = {5,5,5,3,3,3,2,2,1,0};
        HashMap<Integer, Integer> mapa = new HashMap<>();

        for (int liczbaNR2 : tablica14) {
            mapa.put(liczbaNR2, mapa.getOrDefault(liczbaNR2, 0) + 1);
        }

        for (Integer klucz : mapa.keySet()) {
            System.out.println("Liczba " + klucz + " występuje " + mapa.get(klucz) + " razy");
        }
        System.out.println();


        //18. Stwórz tablicę 10 liczb całkowitych i zamień miejscami pierwszy i ostatni element.
        int[] tablica10Liczb = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Zmiana miejsc: ");
        System.out.println(Arrays.toString(tablicaZamienione1zOstatnim(tablica10Liczb)));


        //19. Stwórz tablicę 10 liczb całkowitych i posortuj ją rosnąco. !!! nie korzystajac z klasy Arrays
        int[] tablica10Nieposortowana = {7,5,3,4,9,10,1,2,8,6};
        System.out.println("posortowana tablica = " + Arrays.toString(posortowanaTablica(tablica10Nieposortowana)));

        //sortowanie tablicy - babelkowe


        //20. Stworz tablice, wypelnij ja losowymi liczbami od 1 do 10 i sprawdz czy jest w niej jakas liczba 5 korzystajac z binarySearch
        int[] tablicaDoBinary = {1,2,3,4,6,5,12,1};
        System.out.println("Szukana liczba to 5 = " + czyJestDanaLiczba(tablicaDoBinary,5));
        System.out.println();


        //21. Oblicz srednia arytmetyczna wszystkich liczb w tablicy
        int[] tablicaSredniejArytmetycznej = {1,2,3,4,6,5,12,1};
        System.out.println("Srednia arytmetyczna = " + sredniaArytmetyczna(tablicaSredniejArytmetycznej));
        System.out.println();

        //22. Oblicz mediane wszystkich liczb w tablicy
        int[] mediana = {1,2,3,4,6};
        System.out.println("Mediana = " + mediana(mediana));
        System.out.println();

        //24. Wypisz ostatni element tablicy zakladajac ze nie znasz jej rozmiaru
        int[] ostatniEelement = {1,2,3,4,6,12,123,523,5,1,5,67,7,8};
        System.out.println("Ostatni element = " + ostatniElement(ostatniEelement));
        System.out.println();

        //25. Obroc tablice, czyli z tablicy {1,2,3,4,5} zrob tablice {5,4,3,2,1}

        int[] odwroconaTablica = {1,2,3,4,5};
        System.out.println("Odwrocona tbalica" + Arrays.toString(odwroconaTablica(odwroconaTablica)));



    }

    //25. Obroc tablice, czyli z tablicy {1,2,3,4,5} zrob tablice {5,4,3,2,1}
    public static int[] odwroconaTablica(int[] tablica) {
        for (int i = tablica.length-1; i >= 0; i--) {
            System.out.println(tablica[i]);
        }
        return tablica;
    }

    //24. Wypisz ostatni element tablicy zakladajac ze nie znasz jej rozmiaru
    public static int ostatniElement(int[] tablica) {
        int ostatni = 0;
        for (int i = 0; i < tablica.length; i++) {
            ostatni = tablica[tablica.length-1];
        }
        return ostatni;
    }

    //22. Oblicz mediane wszystkich liczb w tablicy
    public static double mediana(int[] tablica) {
        for (int i = 0; i < tablica.length - 1; i++) {
            for (int j = 0; j < tablica.length - 1 - i; j++) {
                if (tablica[j] > tablica[j + 1]) {
                    int temp = tablica[j];
                    tablica[j] = tablica[j + 1];
                    tablica[j + 1] = temp;
                }
            }
        }
        int n = tablica.length;
        // jeśli nieparzysta liczba elementów
        if (n % 2 != 0) {
            return tablica[n / 2];
        }
        // jeśli parzysta liczba elementów
        return (tablica[n / 2 - 1] + tablica[n / 2]) / 2.0;
    }

    //21. Oblicz srednia arytmetyczna wszystkich liczb w tablicy
    public static double sredniaArytmetyczna (int[] tablica) {
        int srednia = 0;
        int suma = 0;
        for (int i = 0; i < tablica.length; i++) {
            suma += tablica[i];
        }
        srednia = suma / tablica.length;
        return srednia;
    }

    //20. Stworz tablice, wypelnij ja losowymi liczbami od 1 do 10 i sprawdz czy jest w niej jakas liczba 5 korzystajac z binarySearch
    public static int czyJestDanaLiczba(int[] tablica, int danaLiczba) {
        int lewa = 0;
        int prawa = tablica.length-1;
        while (lewa <= prawa) {
            int srodek = lewa + (prawa - lewa) / 2;
            if (tablica[srodek] == danaLiczba) {
                return srodek; // znaleziono element
            }
            if (tablica[srodek] < danaLiczba) {
                lewa = srodek + 1; // szukaj w prawej połowie
            } else {
                prawa = srodek - 1; // szukaj w lewej połowie
            }
        }
        return -1;
    }

    //19. Stwórz tablicę 10 liczb całkowitych i posortuj ją rosnąco. !!! nie korzystajac z klasy Arrays
    public static int[] posortowanaTablica(int[] tablica) {
        for (int i = 0; i < tablica.length - 1; i++) {
            for (int j = 0; j < tablica.length - 1 - i; j++) {
                if (tablica[j] > tablica[j + 1]) {
                    int temp = tablica[j];
                    tablica[j] = tablica[j + 1];
                    tablica[j + 1] = temp;
                }
            }
        }
        return tablica;
    }

    public static int[] tablicaZamienione1zOstatnim(int[] tablica) {
        for (int i =0; i < tablica.length; i++) {
            System.out.println("inde = " + i + " liczba = " + tablica[i]);
        }
        int temp = tablica[0];
        tablica[0] = tablica[tablica.length - 1];
        tablica[tablica.length - 1] = temp;
        return tablica;
    }
}