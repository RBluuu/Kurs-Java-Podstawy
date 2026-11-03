package com.java.course.com.lesson86;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Integer x = 127;
        Integer y = 127;
        System.out.println(x == y);
        System.out.println(x.equals(y));

        String s1 = "pies";
        String s2 = "pies";
        String s3 = "Pies";
        String s4 = new String("pies");
        System.out.println();
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1 == s4); // false
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // false
        System.out.println(s1.equals(s4)); // true
        System.out.println();

        List<Integer> listOf = List.of(123, 123, 3, 321, 3, 21, 321);
        //listOf.add(123); //java.lang.UnsupportedOperationException

        List<Integer> asList = Arrays.asList(12, 32, 21, 32, 1, 312);
        asList.set(0, 999);
        //asList.add(222); //UnsupportedOperationException
        //System.out.println(asList.get(100)); //ArrayIndexOutOfBoundsException

        try {
            FileWriter fileWriter = new FileWriter("plik.txt");
        } catch (IOException e) {
            System.out.println("Ups cos posszlo nie tak");
        }

        Person p1 = new Person("Radek", "Nowak", 31);
        Person p2 = new Person("Radek", "Nowak", 31);
        Person p3 = new Person("Marek", "Kowalski", 33);
        Set<Person> people = new HashSet<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        System.out.println(people);
        System.out.println(people.size());
        p1.setFirstName("Arek");
        System.out.println(people.contains(p1));
        System.out.println(people);
        System.out.println(p1);

        List<Integer> lista = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13, 20, 250, 22, 23, 1, 3, 412, 3));
        List<Integer> lista2 = new ArrayList<>(List.of(5, 4, 3, 2, 1));

        System.out.println(znajdzNajwiekszaLiczba(lista));
        System.out.println();
        //System.out.println(czyPosortowanaLista(lista2));

        //Zadanie 1 – Podstawowe operacje na liście
        //Dana jest lista liczb: [5, 3, 8, 1, 9, 3, 5, 2]. Napisz kod, który:
        //
        //Usuwa duplikaty, zachowując kolejność pierwszego wystąpienia.
        //Sortuje wynik rosnąco.
        //Zwraca tylko elementy większe niż 3.

        List<Integer> listaZad1 = new ArrayList<>(List.of(5, 3, 8, 1, 9, 3, 5, 2));
        System.out.println(zadanieNR1(listaZad1));

        //Masz listę obiektów Pracownik (pola: imie, wiek, pensja). Napisz kod sortujący tę listę:
        //
        //Najpierw po pensja malejąco.
        //Przy remisie — po imie alfabetycznie.

        List<Integer> liczby = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        //Następnie zaproponuj trzy poprawne sposoby usuwania elementów podczas iteracji (np. Iterator.remove(), removeIf(),
        // zbieranie do usunięcia w osobnej liście).


    }

    public static List<Integer> zadanieNR4(List<Integer> lista) {
        List<Integer> nowaLista = new ArrayList<>();
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(liczba -> liczba % 2 != 0)
                .collect(Collectors.toList());
    }

    public static List<Integer> zadanieNR4V2(List<Integer> lista) {

        List<Integer> nowaLista = new ArrayList<>(
                Optional.ofNullable(lista).orElse(Collections.emptyList())
        );

        nowaLista.removeIf(liczba -> liczba != null && liczba % 2 == 0);
        return nowaLista;
    }

        public static List<Pracownik> zadanieNR2 (List < Pracownik > lista) {
            return Optional.ofNullable(lista)
                    .orElse(Collections.emptyList())
                    .stream()
                    .filter(Objects::nonNull)
                    .sorted(Comparator.comparing(Pracownik::getPensja).reversed().thenComparing(Pracownik::getImie))
                    .collect(Collectors.toList());
        }

        public static List<Integer> zadanieNR1 (List < Integer > lista) {
            return Optional.ofNullable(lista)
                    .orElse(Collections.emptyList())
                    .stream()
                    .filter(Objects::nonNull)
                    .filter(liczba -> liczba > 3)
                    .sorted()
                    .distinct()
                    .collect(Collectors.toList());
        }

        public static int znajdzNajwiekszaLiczba (List < Integer > lista) {
            int najwieszkaLiczba = lista.get(0);
            for (int liczba : lista) {
                if (czyLiczbaJestPierwsza(liczba)) {
                    if (liczba > najwieszkaLiczba) {
                        najwieszkaLiczba = liczba;
                    }
                }
            }
            return najwieszkaLiczba;
        }

        public static boolean czyLiczbaJestPierwsza ( int liczba ){
            if (liczba < 2) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(liczba); i++) {
                if (liczba % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public static boolean czyPosortowanaLista (List < Integer > lista) {
            return czyRosnaca(lista) || czyMalejaca(lista);
        }

        public static boolean czyRosnaca (List < Integer > lista) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i) > lista.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }

        public static boolean czyMalejaca (List < Integer > lista) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i) < lista.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }


    }
//string pool
//Person(firstname,lastname,age)

//napisz funkcje ktora przyjmie liste liczb i zwroci najwieksza liczbe pierwsza
//napisz funkcje ktora sprawdzi czy lista jest posortowana malejaco lub rosnaco