package com.java.course.com.lesson84;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>(List.of(1, 1, 2, 2, 2, 3));
        System.out.println(odwroconaListaV1(lista));
        System.out.println();
        System.out.println(czestotliwoscLiczb(lista));
        List<String> listaStringow = new ArrayList<>(List.of("Ala", "Marek"));
        System.out.println(najdluzszyString(listaStringow));
        System.out.println();
        System.out.println(najczescieWystepujacaLitera(listaStringow));
        //1,2,3,4,5,8,9,10
        List<Integer> lista2 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 8, 9, 10));
        System.out.println(brakujacaLiczba(lista2));
    }

    public static List<Integer> odwroconaListaV1(List<Integer> lista) {
        List<Integer> nowaLista = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            nowaLista.add(lista.get(i));
        }
        return nowaLista;
    }

    public static Map<Integer, Integer> czestotliwoscLiczb(List<Integer> lista) {
        Map<Integer, Integer> mapa = new HashMap<>();
        for (int i = 0; i < lista.size(); i++) {
            mapa.put(lista.get(i), mapa.getOrDefault(lista.get(i), 0) + 1);
        }
        return mapa;
    }

    public static List<Integer> listaBezDuplikatow(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    public static String najdluzszyString(List<String> lista) {
        String najdluzszy = lista.get(0);
        for (String slowo : lista) {
            if (slowo.length() > najdluzszy.length()) {
                najdluzszy = slowo;
            }
        }
        return najdluzszy;
    }

    public static char najczescieWystepujacaLitera(List<String> list) {
        Map<Character, Integer> mapa = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            for (char c : list.get(i).toCharArray()) {
                mapa.put(c, mapa.getOrDefault(c, 0) + 1);
            }
        }
        int litera = 0;
        int max = 0;
        for (Map.Entry<Character, Integer> entry : mapa.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                litera = entry.getKey();
            }
        }
        return (char) litera;
    }

    public static int brakujacaLiczba(List<Integer> lista) {
        int szukana = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (!lista.get(i).equals(i)) {
                szukana = lista.get(i);
            }
        }
        return szukana;
    }

    //1. Znajdź drugą największą liczbę w liście liczb całkowitych
    public static int drugaNajwieszkaLiczba(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Takie element nie istnieje"));
    }

    //2. Policz ile razy występuje każdy element w liście Integerów.
    public static Map<Integer, Integer> iloscWystepowan(List<Integer> lista) {
        Map<Integer, Integer> mapa = new HashMap<>();
        for (int i = 0; i < lista.size(); i++) {
            mapa.put(lista.get(i), mapa.getOrDefault(lista.get(i), 0) + 1);
        }
        return mapa;
    }

    public static Map<Integer, Long> iloscWystepowanV2(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

    //3. Znajdź pierwszą liczbę, która występuje tylko raz.
    public static int liczbaWystepujaca1Raz(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Takie element nie istnieje"));
    }

    //4. Usuń wszystkie duplikaty z listy bez używania Set.
    public static List<Integer> listaBezDuplikatowV2(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    //5. Sprawdź czy lista jest posortowana rosnąco.
    public static boolean czyPosortowanaRosnaco(List<Integer> lista) {
        List<Integer> filtered = Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        for (int i = 0; i < filtered.size() - 1; i++) {
            if (filtered.get(i) > filtered.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    //6. Znajdź najdłuższy napis w liście Stringów.
    public static String najdluzszyStringV2(List<String> lista) {
        String najdluzszy = lista.get(0);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).length() > lista.get(i + 1).length()) {
                najdluzszy = lista.get(i);
            }
        }
        return najdluzszy;
    }

    //7. Znajdź literę, która występuje najczęściej we wszystkich napisach listy.
    public static char najpopularniejszaLiteraV2(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();
    }

    //8. Posortuj listę napisów według długości malejąco.
    public static List<String> odwroconaLista(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
    }

    //9. Znajdź wszystkie napisy rozpoczynające się od podanej litery.
    public static List<String> listaNaLitereX(List<String> lista, char szukanaLitera) {
        List<String> listaWyrazow = new ArrayList<>();
        for (String slowo : lista) {
            if (slowo.charAt(0) == szukanaLitera) {
                listaWyrazow.add(slowo);
            }
        }
        return listaWyrazow;
    }

    public static List<String> listaNaLitereXV2(List<String> lista, char szukanaLitera) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(slowo -> !slowo.isEmpty())
                .filter(slowo -> slowo.charAt(0) == szukanaLitera)
                .collect(Collectors.toList());
    }

    //10. Policz całkowitą liczbę znaków we wszystkich napisach listy.
    public static int liczbaZnakow(List<String> lista) {
        int suma = 0;
        for (String slowo : lista) {
            suma += slowo.length();
        }
        return suma;
    }
    public static int liczbaZnakowV2(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(String::length)
                .sum();
    }

}
//napisz funkcje ktora obroci liste 1,2,3,4 -> 4,3,2,1
//napisz funkcje ktora przyjmie liste i zwroci czestotliwosci cyfr
//1,1,2,2,2,3 - > 1-2 2-3 3-1
//przyjmij liste i zwroc liste bez duplikatow
//1,1,1,2,2,2,3,3,3 -> 1,2,3
//znajdz najdlizszy napis w liscie Stringow
//w liscie stringow znajdz litere ktora wystepuje najczesciej
//lista zawiera liczby od 1 do 10
//znajdz brkujaca liczbe
//1,2,3,4,5,8,9,10 -> 7


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