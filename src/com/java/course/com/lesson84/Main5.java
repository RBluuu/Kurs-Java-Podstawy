package com.java.course.com.lesson84;

import java.util.*;
import java.util.stream.Collectors;

public class Main5 {
    public static void main(String[] args) {
        /*
        Masz listę imion. Zwróć mapę gdzie:
        - klucz to pierwsza litera imienia (uppercase)
        - wartość to lista imion zaczynających się na tę literę, posortowana alfabetycznie

        Wejście:  ["anna", "adam", "bartek", "beata", "celina"]
        Wyjście:  {A→["adam", "anna"], B→["bartek", "beata"], C→["celina"]}
         */
        List<String> listaImion = new ArrayList<>(List.of("anna", "adam", "bartek", "beata", "celina"));
        System.out.println("Zadanie nr 1 " + mapaZZadaniaNr1(listaImion));
        System.out.println();

        /*
        Masz listę zdań. Zwróć długość najdłuższego słowa
        spośród wszystkich słów ze wszystkich zdań.
        Ignoruj wielkość liter i interpunkcję [.,!?].

        Wejście:  ["ala ma kota", "kot ma alę!", "bardzo długie słowo"]
        Wyjście:  6  (słowo "bardzo" lub "długie")
         */
        List<String> listaStringow = new ArrayList<>(List.of("ala ma kota", "kot ma alę!", "bardzo długie słowo"));
        System.out.println("Zadanie nr 2 = " + wielkoscNajdluzeszegoWrazu(listaStringow) );

        /*
        Masz listę liczb całkowitych. Bez używania sum(), count()
        ani żadnego Collector — tylko reduce() — zwróć średnią arytmetyczną.
        Zwróć OptionalDouble.

        Wejście:  [1, 2, 3, 4, 5]
        Wyjście:  OptionalDouble[3.0]
         */

        /*
        Masz listę stringów w formacie "imię:wynik" gdzie wynik to liczba.
        Znajdź imię osoby z najwyższą sumą wyników
        (ta sama osoba może wystąpić wielokrotnie).

        Wejście:  ["anna:10", "bartek:20", "anna:30", "bartek:5", "celina:50"]
        Wyjście:  "anna"  (suma: 40 > bartek: 25 < celina: 50)
         */

    }

    public static String imieZNajwiekszymWynikiem(List<String> lista){
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> s.contains(":"))                        // ← pomiń błędny format
                .collect(Collectors.groupingBy(
                        s -> s.split(":")[0],                        // ← klucz: imię
                        Collectors.summingInt(s -> Integer.parseInt(s.split(":")[1])) // ← suma wyników
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())                   // ← najwyższa suma
                .map(Map.Entry::getKey)                              // ← wyciągnij imię
                .orElseThrow(() -> new NoSuchElementException("Lista jest pusta"));
    }

    /*public static Optional sredniaArytmetyczna(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .reduce()
    }

     */

    public static int wielkoscNajdluzeszegoWrazu(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMap(zdanie -> Arrays.stream(zdanie.split("\\s+"))) // ← rozbij zdania na słowa
                .map(slowo -> slowo.replaceAll("[.,!?]", ""))           // ← usuń interpunkcję
                .filter(slowo -> !slowo.isEmpty())                      // ← usuń puste po replaceAll
                .mapToInt(String::length)                               // ← zamień na długość
                .max()                                                  // ← znajdź największą
                .orElseThrow(() -> new NoSuchElementException("Lista jest pusta"));
    }

    public static Map<Character,List<String>> mapaZZadaniaNr1(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.groupingBy(
                        litera -> litera.toUpperCase().charAt(0),
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                imie -> imie.stream()
                                        .sorted()
                                        .collect(Collectors.toList())
                        )
                ));
    }
}
