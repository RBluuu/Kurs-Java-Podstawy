package com.java.course.com.przykladyNowe;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        //1. Napisz program z pętlą for, który wyświetla wszystkie liczby pierwsze mniejsze od 100.
        //2. Stwórz program z pętlą while, który oblicza silnię liczby 10.
        //3.Użyj pętli do-while do napisania programu, który oblicza sumę kwadratów pierwszych 15 liczb naturalnych.
        //5.Stworz 5 elementowa tablice i wypelnij ja liczbami od 1 do 5
        //6.Stworz 1000 elementowa tablice i wypelnij ja liczbami od 1 do 1
        //8.Stworz 10 elementowa tablice i wypelnij ja liczbami parzystymi od 2 do 20
        //9.Stworz dowolna tablice i wypisz jej elementy, ale tylko te pod parzystymi indeksami

        //1. Napisz program z pętlą for, który wyświetla wszystkie liczby pierwsze mniejsze od 100.
        System.out.println("Zadanie 1:");
        for (int i = 2; i < 100; i++) {
            boolean pierwsza = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    pierwsza = false;
                    break;
                }
            }
            if (pierwsza) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        //2. Stwórz program z pętlą while, który oblicza silnię liczby 10.
        System.out.println("Zadanie 2:");
        int silna10 = 10;
        int wynik = 1;
        while (silna10 > 0) {
            wynik *= silna10;
            silna10--;
        }
        System.out.println("SILNA = " + wynik);
        System.out.println();

        //3.Użyj pętli do-while do napisania programu, który oblicza sumę kwadratów pierwszych 15 liczb naturalnych.
        System.out.println("Zadanie 3:");
        int suma1 = 0;
        int i = 1;

        do {
            suma1 += i * i;
            i++;
        } while (i <= 15);

        System.out.println("Suma = " + suma1);
        System.out.println();

        //5.Stworz 5 elementowa tablice i wypelnij ja liczbami od 1 do 5
        System.out.println("Zadanie 5:");
        int[] tablica = new int[5];
        for (int x = 0; x < 5; x++) {
            tablica[x] = x + 1;
        }
        for (int x2 = 0; x2 < 5; x2++) {
            System.out.print(tablica[x2] + " ");
        }
        System.out.println();

        //6.Stworz 1000 elementowa tablice i wypelnij ja liczbami od 1 do 1000
        System.out.println("Zadanie 6:");
        int[] tablica1000 = new int[1000];
        for (int a = 0; a < 1000; a++) {
            tablica1000[a] = a + 1;
        }
        for (int b = 0; b < 1000; b++) {
            System.out.print(tablica1000[b] + " ");
        }
        System.out.println();

        //8.Stworz 10 elementowa tablice i wypelnij ja liczbami parzystymi od 2 do 20
        System.out.println("Zadanie 8:");
        int[] tablica10 = new int[10];
        for (int z = 0; z < 10; z++) {
            tablica10[z] = (z + 1) * 2;
        }
        for (int k = 0; k < 10; k++) {
            System.out.print(tablica10[k] + " ");
        }
        System.out.println();

        //9.Stworz dowolna tablice i wypisz jej elementy, ale tylko te pod parzystymi indeksami
        System.out.println("Zadanie 9:");
        int[] tablica15 = new int[15];
        for (int d = 1; d < 15; d++) {
            tablica15[d] = d;
        }
        for (int e = 1; e < 15; e++) {
            if (e % 2 == 0) {
                System.out.print(tablica15[e] + " ");
            }
        }
        System.out.println();

        //Przykladowe zadanie z petli wheil:
        //1 Wypisywanie liczb od 1 do 10
        //Napisz program, który za pomocą pętli while wypisze liczby od 1 do 10.
        System.out.println("Zadanie 1:");
        int a = 1;
        while (a <= 10) {
            System.out.println(a);
            a++;
        }
        System.out.println();
        //2 Suma liczb od 1 do n
        //Napisz program, który pobierze od użytkownika liczbę n, a następnie obliczy sumę wszystkich liczb od 1 do n przy użyciu pętli while.
        //Przykład:
        //Dla n = 5 wynik powinien wynosić 15.
        System.out.println("Zadanie 2:");
        System.out.println("Napisz liczbe od 5 do 10:");
        Scanner sc = new Scanner(System.in);
        int liczbaKlienta = sc.nextInt();
        int sumaLiczbA = 0;
        int d = 1;
        while (d <= liczbaKlienta) {
            sumaLiczbA = sumaLiczbA + d;
            d++;
        }
        System.out.println("Wynik = " + sumaLiczbA);
        System.out.println();

        //3 Napisz program, który pobierze liczbę od użytkownika i będzie wypisywał liczby od podanej wartości do 0 (włącznie) używając pętli while.
        //Przykład:
        //Dla 5 program wypisze: 5 4 3 2 1 0
        System.out.println("Zadanie 3 :");
        System.out.println("Liczby: ");
        while (liczbaKlienta >= 0) {
            System.out.println(liczbaKlienta);
            liczbaKlienta--;
        }
        System.out.println();

        //4 Sprawdzanie hasła
        //Napisz program, który będzie prosił użytkownika o podanie hasła tak długo, aż poda poprawne hasło (np. "python123").
        //Wykorzystaj pętlę while.
        System.out.println("Zadane nr4" );
        System.out.println("Podaj haslo");
        Scanner sc2 = new Scanner(System.in);
        String haslo = sc2.nextLine();
        String haslo1 = "java";
        while (!haslo.equalsIgnoreCase(haslo1)) {
            System.out.println("Bledne haslo, sproboj ponownie:\"");
            haslo = sc2.nextLine();
        }
        System.out.println("Jest ok, haslo to = " + haslo1 );
        System.out.println();
        //5 Liczenie cyfr w liczbie
        //Napisz program, który pobierze od użytkownika liczbę całkowitą i za pomocą pętli while policzy, ile ma ona cyfr.
        //Przykład:
        //Dla liczby 12345 wynik powinien wynosić 5.
        System.out.println("Zadanie 5: ");
        System.out.println("Podaje liczbe calkowita: ");
        Scanner sc3 = new Scanner(System.in);
        int liczba = sc3.nextInt();
        int sumaLiczb = 0;
        while (liczba != 0) {
            liczba = liczba / 10;
            sumaLiczb++;
        }
        System.out.println("Dlugosc liczby to = " + sumaLiczb);


    }
}
