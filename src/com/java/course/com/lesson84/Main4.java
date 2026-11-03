package com.java.course.com.lesson84;

import java.util.*;
import java.util.stream.Collectors;

public class Main4 {
    public static void main(String[] args) {
    }
    //1. Znajdź drugą największą liczbę w liście liczb całkowitych.
    public static Integer drugaNajwiekszaLiczba(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Brak drugiej największej liczby"));
    }

    //2. Policz ile razy występuje każdy element w liście Integerów.
    public static Map<Integer,Long> mapa(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        liczba -> liczba,
                        Collectors.counting()
                ));
    }

    //3. Znajdź pierwszą liczbę, która występuje tylko raz.
    public static int wystepujeTylkoRaz(List<Integer> lista) {
        Map<Integer, Long> licznik = Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        liczba -> liczba,
                        Collectors.counting()
                ));

        return Optional.ofNullable(lista)       // ← drugie przejście zachowuje kolejność
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(l -> licznik.getOrDefault(l, 0L) == 1L)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Brak liczby występującej tylko raz"));

    }

    //4. Usuń wszystkie duplikaty z listy bez używania Set.
    public static List<Integer> listaBezDuplikatow(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    //5. Sprawdź czy lista jest posortowana rosnąco.
    public static boolean czyRosnaco(List<Integer> lista) {
        for (int i = 0; i < lista.size()-1; i++) {
            if (lista.get(i) > lista.get(i + 1))
                return false;
        }
        return true;
    }

    //6. Znajdź najdłuższy napis w liście Stringów.


    //7. Znajdź literę, która występuje najczęściej we wszystkich napisach listy.

    //8. Posortuj listę napisów według długości malejąco.

    //9. Znajdź wszystkie napisy rozpoczynające się od podanej litery.

    //10. Policz całkowitą liczbę znaków we wszystkich napisach listy.
}
