package com.java.course.com.lesson87;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 123, 124, 122));
        fun(numbers);
        System.out.println(numbers);

        String imie = "Radekkk";
        System.out.println(iloscLiterWWyrazieV2(imie));

        String imie2 = "Ala";
        System.out.println(czyJestPalindromem(imie2));

        List<String> slowa = List.of("jabłko", "gruszka", "śliwka", "arbuz", "banan", "ananas");
        System.out.println();
        System.out.println(listaWyrazowOOkreslonejDlugosci(slowa, 5));
        System.out.println();


        System.out.println(listaWyrazowOOkreslonejDlugosciV2(slowa, 5));
        System.out.println();
        System.out.println(listaWyrazowOOkreslonejDlugosciV3(slowa, 5));
        System.out.println();

        List<Integer> listaLiczb2 = new ArrayList<>(List.of(15, 8, 23, 4, 42, 16, 9, 31));
        System.out.println(listaLiczbZZadania(listaLiczb2));
        System.out.println();

        List<String> lista3 = new ArrayList<>(List.of("kot", "pies", "kot", "koń", "pies", "słoń", "kot", "lis"));
        System.out.println(listaSlow(lista3));

        for (int i = 0, j = 5; i < j; i++, j--) {
            System.out.println("i=" + i + " j=" + j);
        }

        int[] liczby = {4, 8, 15, 16, 23, 42};
    }

    public static int indeksPierwszejPodzielnejPrzez7(int[] liczby) {
        for (int i = 0; i < liczby.length; i++) {
            if (liczby[i] % 7 == 0) {
                return i;
            }
        }
        return -1;
    }

        /*
        public static int indeksPierwszejPodzielnejPrzez7(int[] liczby) {
    // Twoja implementacja
}
Dla int[] liczby = {4, 8, 15, 16, 23, 42} metoda ma zwrócić indeks pierwszej liczby podzielnej przez 7, albo -1, jeśli takiej nie ma.
         */

        /*
        Napisz kod używający Stream API, który:

        Filtruje słowa dłuższe niż 5 znaków
        Mapuje je na wielkie litery
        Sortuje alfabetycznie
        Bierze pierwsze 2 elementy
        Zbiera do listy
         */


        /*
        Ma listę liczb całkowitych: List.of(15, 8, 23, 4, 42, 16, 9, 31).
Zbuduj stream, który:
filtruje liczby parzyste,
sortuje malejąco,
mapuje każdą liczbę na jej kwadrat,
ogranicza wynik do pierwszych 3,
zbiera do List<Integer>.
         */
        /*
        Ma listę stringów: List.of("kot", "pies", "kot", "koń", "pies", "słoń", "kot", "lis").
Buduje stream, który:

filtruje słowa dłuższe niż 3 znaki,
stosuje distinct(),
mapuje na długość słowa (String::length),
ogranicza do pierwszych 2 wyników,
zbiera do listy.
         */

    public static int sumaParzystych(int[] liczby) {
        int suma = 0;
        for (int i = 0; i < liczby.length ; i++) {
           if (liczby[i] % 2 == 0) {
               suma+=liczby[i];
           }
        }
        return suma;
    }

    public static List<Integer> listaSTRINGOW(List<String> lista, int slowoDluzszeNiz) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(slowo -> slowo.length() > slowoDluzszeNiz)
                .distinct()
                .map(String::length)
                .limit(2)
                .collect(Collectors.toList());
    }

    public static List<Integer> listaLiczbParzystchDoKwadratu(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(liczba -> liczba % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .map(liczba -> liczba * liczba)
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<Integer> listaSlow(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(slowo -> {
                    System.out.println("wyswielenie: " + slowo);
                    return slowo.length() > 3;})
                .distinct()
                .map(slowo -> {
                    System.out.println("map: " + slowo);
                    return slowo.length();})
                .limit(2)
                .collect(Collectors.toList());
    }

    public static List<Integer> listaLiczbZZadania(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(liczba -> {
                        System.out.println("filter parzyste: " + liczba);
                        return liczba % 2 == 0;})
                .sorted((a, b) -> {
                            System.out.println("sortowanie: " + a + " vs " + b);
                            return Comparator.<Integer>reverseOrder().compare(a, b);
                        })
                .map(liczba -> {
                    System.out.println("mapa liczby: " + liczba);
                    return liczba * liczba;})
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<String> listaWyrazowOOkreslonejDlugosci(List<String> listaWyrazow, int dlugoscWyrazu) {
        return Optional.ofNullable(listaWyrazow)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter( slowo -> slowo.length() > dlugoscWyrazu)
                .peek(s -> System.out.println("peek: " + s))
                .map(String::toUpperCase)
                .peek(s -> System.out.println("peek: " + s))
                .sorted()
                .peek(s -> System.out.println("peek: " + s))
                .collect(Collectors.toList());
    }


    public static List<String> listaWyrazowOOkreslonejDlugosciV2(List<String> listaWyrazow, int dlugoscWyrazu) {
        return Optional.ofNullable(listaWyrazow)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted()
                .filter( slowo -> slowo.length() > dlugoscWyrazu)
                .peek(s -> System.out.println("peek: " + s))
                .map(String::toUpperCase)
                .peek(s -> System.out.println("peek: " + s))
                .limit(2)
                .peek(s -> System.out.println("peek: " + s))
                .collect(Collectors.toList());
    }
    public static List<String> listaWyrazowOOkreslonejDlugosciV3(List<String> listaWyrazow, int dlugoscWyrazu) {
        return Optional.ofNullable(listaWyrazow)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted()
                .filter( slowo -> slowo.length() > dlugoscWyrazu)
                .peek(s -> System.out.println("peek: " + s))
                .map(String::toUpperCase)
                .peek(s -> System.out.println("peek: " + s))
                .limit(2)
                .peek(s -> System.out.println("peek: " + s))
                .collect(Collectors.toList());
    }

    //Napisz metodę, która z listy produktów (List<Produkt>) zwraca najdroższy produkt. Jeśli:
    //
    //lista jest null lub pusta → zwróć null

    public static Produkt znajdzNajdrozszyProdukt(List<Produkt> listaProduktow) {
        return Optional.ofNullable(listaProduktow)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(Produkt::getCena))
                .orElse(null);
    }

    //Napisz metodę, która z listy liczb całkowitych (List<Integer>) zwraca najmniejszą liczbę parzystą.
    public static Integer najmniejszaParzystaLiczba(List<Integer> listaLiczb) {
        if (listaLiczb == null || listaLiczb.isEmpty()) {
            return null;
        }
        Integer najmniejszLiczbaZListy = null;
        for(Integer liczba : listaLiczb) {
            if (liczba % 2 == 0) {
                if (najmniejszLiczbaZListy == null || liczba < najmniejszLiczbaZListy) {
                    najmniejszLiczbaZListy = liczba;
                }
            }
        }
        return najmniejszLiczbaZListy;
    }

    public static String najdluzszeSlowoNaLiscie(List<String> listaSlow) {
        if (listaSlow == null || listaSlow.isEmpty()) {
            return null;
        }
        String dlugoscSlowa = listaSlow.get(0);
        for (String slowo : listaSlow) {
            if (slowo.length() > dlugoscSlowa.length()) {
                dlugoscSlowa = slowo;
            }
        }
        return dlugoscSlowa;
    }
    //2.Napisz funkcje ktora sprawdzi czy slowo jest palindromem
    //3. napisz funkcje ktora znajdzie najdluzszy powtarzajacy sie fragment tekstu z listy slow, najdluzszy wspolny prefix
    //aabbcc,aabc,aa -> aa

    /*public static String najdluzszyWspolnyPrefix(List<String> listaSlow) {
        String prefix = null;
        for (int i = 0; i < listaSlow.size() ; i++) {
            for (int j = 0; j < i; j++) {
                if ( )
            }
        }
    }

     */
    public static boolean czyJestPalindromem(String slowo) {
        int lewy = 0;
        int prawy = slowo.length()-1;
        while (lewy < prawy) {
            if (slowo.charAt(lewy) != slowo.charAt(prawy)) {
                return false;
            }
            lewy++;
            prawy--;
        }
        return true;
    }

    //1. Napisz funkcję, która policzy ilość liter w wyrazie.
    /*public static Map<Character,Long> iloscLiterWWyrazie(String slowo) {
        Map<Character,Long> mapa = new HashMap<>();
        return Optional.ofNullable(slowo)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Character::charValue,
                        Collectors.counting()
                ));
    }

     */

    public static Map<Character,Integer> iloscLiterWWyrazieV2(String slowo) {
        Map<Character,Integer> mapa = new HashMap<>();
        for(char litera : slowo.toCharArray()) {
            mapa.put(litera,mapa.getOrDefault(litera,0)+1);
        }
        return mapa;
    }


    public static void fun(List<Integer> numbers){
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if(number %  2 == 0){
                numbers.remove(Integer.valueOf(number));
                i--;
            }
        }
    }
}
