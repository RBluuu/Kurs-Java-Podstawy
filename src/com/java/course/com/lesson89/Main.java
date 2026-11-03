package com.java.course.com.lesson89;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4));

        numbers.set(0,999);
        System.out.println(numbers);
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        //numbers2.add(123);
        numbers2.set(0,999);
        System.out.println(numbers2);
        System.out.println();
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s2));// true
        System.out.println(s1.equals(s3));// true
        System.out.println();
        numbers.add(123);
        Integer toRemove = 123;
        numbers.remove(toRemove);
        System.out.println(numbers);
        System.out.println();
        Set<Person> people = new HashSet<>();
        Person jan = new Person("Jan", "Kowalski");
        people.add(jan);
        jan.setFirstName("Marek");
        //people.add(new Person("Jan","Kowalski"));
        people.add(new Person("Arek","Nowak"));
        System.out.println(people);
        System.out.println(people.contains(jan));
        System.out.println(people.size());
        List<Integer> list = List.of(1,2,1,2,3,4,5,1,2);
        System.out.println(list);
        System.out.println(list.subList(2,5));
        System.out.println(najdluzszyCiagLiczb(list));
        System.out.println(czyPosortowana(list));
        System.out.println(czyPosortowana(List.of(1,2,3,4,5)));
        System.out.println(czyPosortowana(List.of(5,4,3,2,1)));

        List<Contribution> wplaty = new ArrayList<>(List.of(
                new Contribution(new BigDecimal("5000"), LocalDate.of(2026, 7, 27), "Pierwsza wypłata"),
                new Contribution(new BigDecimal("3000"), LocalDate.of(2026, 8, 1), "Oszczędności"),
                new Contribution(new BigDecimal("10000"), LocalDate.of(2026, 7, 15), "Bonus"),
                new Contribution(new BigDecimal("1500"), LocalDate.of(2026, 9, 3), "Nadgodziny")
        ));

        //Zwykła pętla, bez streamów — wypisz na konsolę wszystkie wpłaty, jedna linijka na wpłatę (kwota + data).
        wypisanieKwotyIDaty(wplaty);

    }
    //Zadanie 3 — posortuj listę wpłat na dwa sposoby:
    //
    //Od najmniejszej do największej kwoty
    //Od najnowszej do najstarszej daty

    //Napisz dwie metody:
    //
    //sumaWplat(List<Contribution> lista) — zwraca BigDecimal, sumę wszystkich kwot.
    //sredniaWplat(List<Contribution> lista) — zwraca BigDecimal, średnią kwotę.

    //napisz metodę sumaPoMiesiacu(List<Contribution> lista),
    // która zwraca Map<String, BigDecimal> — klucz to miesiąc (np. "2026-07"), wartość to suma wpłat z tego miesiąca.

    public static Map<String, BigDecimal> sumaPoMiesiacu(List<Contribution> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        c -> c.getData().getYear() + "-" + c.getData().getMonthValue(),
                        Collectors.reducing(BigDecimal.ZERO, Contribution::getKwota, BigDecimal::add)));

    }

    public static BigDecimal suma(List<Contribution> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(Contribution::getKwota)
                .reduce(BigDecimal.ZERO,
                        BigDecimal::add);

    }

    public static BigDecimal sredniaWplat(List<Contribution> lista) {
        if (lista == null || lista.isEmpty()) return BigDecimal.ZERO;

         return suma(lista)
                .divide(BigDecimal.valueOf(lista.size()), 2, RoundingMode.HALF_UP);
    }



        public static List<Contribution> posortowanaOdNajmniejszejDoNajwiekszej(List<Contribution> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Contribution::getKwota))
                .collect(Collectors.toList());
    }

    public static List<Contribution> posortowanaOdNajnowszejDaty(List<Contribution> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Contribution::getData).reversed())
                .collect(Collectors.toList());
    }

    public static void wypisanieKwotyIDaty(List<Contribution> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getKwota() + " + " + lista.get(i).getData());
        }
    }

    public static List<Contribution> wplatyPowyzejKwoty(List<Contribution> lista, BigDecimal kwota) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(contribution -> contribution.getKwota().compareTo(kwota) > 0)
                .collect(Collectors.toList());
    }

















    //Napisz metode ktora przyjmie liste intow i zwroci najdluzszy ciag
    //[1,2,1,2,3,4,5,1,2] -> 1,2,3,4,5
    //Napisz metode ktora sprawdzi czy lista jest posortowana (rosnaco lub malejaco)

    //Napisz funkcje ktora przyjmie liste i jakas liczbe i zwroci indeksy liczb z listy ktore sumuja sie do tej wartosci
    //func([1,2,3,4,5],5) -> 1,2

    public static List<Integer> zadanie(List<Integer> lista, int szukanaLiczba) {
        List<Integer> listaLiczb = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            for (int j = i+1; j < lista.size(); j++) {
                if (lista.get(i) + lista.get(j) == szukanaLiczba) {
                    listaLiczb.add(lista.get(i));
                    listaLiczb.add(lista.get(j));
                }
            }
        }
        return listaLiczb;
    }
    public static boolean czyPosortowana(List<Integer> listaLiczb) {
        boolean posortowanaRosnaco = true;
        boolean posrtowanaMalejaco = true;
        for (int i = 0; i < listaLiczb.size()-1; i++) {
            int obecnaLiczba = listaLiczb.get(i);
            int nastepnaLiczba = listaLiczb.get(i+1);
            if (obecnaLiczba > nastepnaLiczba) {
                posortowanaRosnaco = false;
            }
            if (obecnaLiczba < nastepnaLiczba) {
                posrtowanaMalejaco = false;
            }
        }
        return posortowanaRosnaco || posrtowanaMalejaco;
    }

    public static List<Integer> najdluzszyCiagLiczb(List<Integer> lista) {
        if (lista == null || lista.isEmpty()) {
            return List.of();
        }

        int bestStart = 0;
        int bestLength = 1;

        int currentStart = 0;
        int currentLength = 1;

        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i) == lista.get(i - 1) + 1) {
                currentLength++;
            } else {
                if (currentLength > bestLength) {
                    bestLength = currentLength;
                    bestStart = currentStart;
                }

                currentStart = i;
                currentLength = 1;
            }
        }

        // Sprawdzenie ostatniego ciągu
        if (currentLength > bestLength) {
            bestLength = currentLength;
            bestStart = currentStart;
        }

        return new ArrayList<>(lista.subList(bestStart, bestStart + bestLength));
    }
}
