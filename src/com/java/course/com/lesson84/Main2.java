package com.java.course.com.lesson84;

import java.util.*;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> listaLiczb1 = new ArrayList<>(List.of(1,2,3,4,5));
        System.out.println("Zadanie 1 = " + drugaNajwiekszaLiczba(listaLiczb1));
        List<Integer> listaLiczb2 = new ArrayList<>(List.of(1,2,3,4,5,5,6,6,7,7,7,7,7,7,7,7,7,7));
        System.out.println("Zadanie 2 " + iloscWystepowanIntow(listaLiczb2));
    }

    //1. Znajdź drugą największą liczbę w liście liczb całkowitych.
    public static int drugaNajwiekszaLiczba(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Nie istenieje taki element"));
    }

    //2. Policz ile razy występuje każdy element w liście Integerów.
    public static Map<Integer,Long> iloscWystepowanIntow(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.groupingBy(
                        liczba -> liczba,
                        Collectors.counting()
                ));
    }

    //3. Znajdź pierwszą liczbę, która występuje tylko raz.
    public static int pierwszaWystepujaca1Raz(List<Integer> lista) {
        Map<Integer,Long> mapa =  Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        liczba -> liczba,
                        Collectors.counting()
                ));
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(liczba -> mapa.getOrDefault(liczba, 0L) == 1L)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Element nie istnieje"));
    }

    //4. Usuń wszystkie duplikaty z listy bez używania Set.
    public static List<Integer> listaBezDuplikatow(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    //5. Sprawdź czy lista jest posortowana rosnąco.
    public static boolean listaCzyPosortowana(List<Integer> lista) {
        for (int i = 0; i < lista.size()-1; i++) {
            if (lista.get(i) > lista.get(i+1))
                return false;
        }
        return true;
    }

    //6. Znajdź najdłuższy napis w liście Stringów.
    public static String najdluzszyString(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(String::length))
                .orElseThrow(() -> new NoSuchElementException("Lista jest pusta"));
    }

    //7. Znajdź literę, która występuje najczęściej we wszystkich napisach listy.
    public static char literaWystepujacaNajczescie(List<String> lista) {
        Map<Character,Integer> mapa = new HashMap<>();
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMap(slowo -> slowo.chars()          // ← rozbij każdy String na znaki
                        .mapToObj(c -> (char) c))
                .filter(Character::isLetter)             // ← tylko litery, bez spacji/cyfr
                .collect(Collectors.groupingBy(
                        litera -> litera,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())        // ← znajdź najczęstszą
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new NoSuchElementException("Brak liter na liście"));
    }

    //8. Posortuj listę napisów według długości malejąco.
    public static List<String> malejaco(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
    }

    //9. Znajdź wszystkie napisy rozpoczynające się od podanej litery.

    //10. Policz całkowitą liczbę znaków we wszystkich napisach listy.
}







//1. Znajdź drugą największą liczbę w liście liczb całkowitych.

//2. Policz ile razy występuje każdy element w liście Integerów.

//3. Znajdź pierwszą liczbę, która występuje tylko raz.

//4. Usuń wszystkie duplikaty z listy bez używania Set.

//5. Sprawdź czy lista jest posortowana rosnąco.

//6. Znajdź najdłuższy napis w liście Stringów.

//7. Znajdź literę, która występuje najczęściej we wszystkich napisach listy.

//8. Posortuj listę napisów według długości malejąco.

//9. Znajdź wszystkie napisy rozpoczynające się od podanej litery.

//10. Policz całkowitą liczbę znaków we wszystkich napisach listy.
