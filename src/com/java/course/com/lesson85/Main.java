package com.java.course.com.lesson85;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<int[]> lista = List.of(
                new int[]{1,2},
                new int[]{2,4},
                new int[]{1,2,4}
        );
        List<Integer> lista2 = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10,20,30));
        System.out.println(Arrays.toString(najdluzszaLista(lista)));
        System.out.println(drugiNajmniejszyElement(lista));
        System.out.println(liczbaElementowWiekszychOdSredniej(lista2));
        System.out.println(liczbaPierwszaPowtarzajaca(lista));

    }
    public static int[] najdluzszaLista(List<int[]> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(tablica -> tablica.length))
                .orElseThrow();
    }

    public static int drugiNajmniejszyElement(List<int[]> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMapToInt(Arrays::stream)
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElseThrow();
    }

    public static int liczbaElementowWiekszychOdSredniej(List<Integer> lista) {
        double srednia = lista.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow();

        return (int) Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(liczba -> liczba > srednia)
                .count();
    }

    public static int liczbaPierwszaPowtarzajaca(List<int[]> lista) {
        int[] firstArray = lista.get(0);
        for (int candidate : firstArray) {
            boolean presentInAll = true;
            for (int i = 1; i < lista.size(); i++) {
                boolean found = false;
                for (int number : lista.get(i)) {
                    if(number == candidate){
                        found = true;
                        break;
                    }
                }
                if(!found){
                    presentInAll = false;
                    break;
                }
            }
            if(presentInAll){
                return  candidate;
            }
        }
        throw new IllegalArgumentException("element not found");
    }

    private static boolean czyParzysta(int n) {
        if ( n < 2) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static List<Integer> listaLiczbMniejszychOd(List<int[]> lista, int wartosc) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMapToInt(Arrays::stream)
                .filter(liczba -> liczba < wartosc)
                .boxed()
                .toList();
    }
}
//napisz funkcje ktora przyjmie liste tablic intow i zwroci te tablice ktora ma najwieksza dlugosc
//napsiz funkcje ktora przyjmie liste tablic intow i zwroci drugi najmniejszy element z tych tablic
// 31. Napisz funkcję, która policzy liczbę elementów większych od średniej wszystkich elementów.
////39. Napisz funkcję, która znajdzie pierwszą liczbę powtarzającą się we wszystkich tablicach.
////27. Napisz funkcję, która zwróci listę wszystkich liczb mniejszych od podanej wartości.
