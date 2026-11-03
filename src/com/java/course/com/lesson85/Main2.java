package com.java.course.com.lesson85;

import java.util.*;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        //Utwórz ArrayList<String> z imionami: "Anna", "Bartek", "Celina", "Dawid".
        // Usuń element o indeksie 1, a następnie dodaj "Ewa" na końcu. Wypisz całą listę.
        List<String> listaImion = new ArrayList<>(List.of("Anna", "Bartek", "Celina", "Dawid"));
        System.out.println("Nowa Lista = " + listaZImionami(listaImion, 1));

        //Masz listę liczb całkowitych od 1 do 20.
        // Utwórz nową listę zawierającą tylko liczby parzyste. Skorzystaj z pętli for-each lub strumieni (Stream API).

        List<Integer> listaLiczb = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        System.out.println(listaLiczbParzystych(listaLiczb));

        //Stwórz klasę Produkt z polami nazwa (String) i cena (double).
        // Utwórz listę kilku produktów, a następnie posortuj ją rosnąco według ceny używając Collections.sort() lub Comparator.
        List<Produkt> produkty = new ArrayList<>();
        produkty.add(new Produkt("Laptop", 3499.99));
        produkty.add(new Produkt("Słuchawki", 249.00));
        produkty.add(new Produkt("Mysz", 89.90));
        produkty.add(new Produkt("Monitor", 1799.00));
        produkty.add(new Produkt("Klawiatura", 159.50));
        System.out.println(listaTowarowRosnaco(produkty));

        //Użyj LinkedList<Integer> jako kolejki (FIFO). Dodaj liczby 10, 20, 30, 40 na koniec listy,
        // a następnie pobieraj i wypisuj elementy jeden po drugim z początku listy, aż lista będzie pusta.
        LinkedList<Integer> kolejka = new LinkedList<>();
        // dodawanie na koniec
        kolejka.offer(10);
        kolejka.offer(20);
        kolejka.offer(30);
        kolejka.offer(40);
        // pobieranie z początku aż lista będzie pusta
        while (!kolejka.isEmpty()) {
            System.out.println(kolejka.poll());
        }

        //Dana jest lista liczb z powtórzeniami: [3, 1, 4, 1, 5, 9, 2, 6, 5, 3].
        // Usuń duplikaty zachowując kolejność pierwszego wystąpienia.
        // Zrób to bez używania Set (tylko operacje na liście) oraz drugi wariant – z użyciem LinkedHashSet.
        //
        //List<Integer> lista = new ArrayList<>(Arrays.asList(3,1,4,1,5,9,2,6,5,3));
        //// wariant 1: bez Set (ręcznie)
        //// wariant 2: przez LinkedHashSet
        List<Integer> listaLiczbMieszana = new ArrayList<>(List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3));
        System.out.println("Zadaniae listy bez dupliaktow = " + bezduplikatow(listaLiczbMieszana));

        //Mając List<Integer> z duplikatami, usuń powtórzenia, ale zachowaj oryginalną kolejność pierwszego wystąpienia.
        // Najpierw rozwiązanie z LinkedHashSet, potem wariant ręczny z HashSet jako "widziane" + nowa lista.
        // Pytanie pogłębiające: czym LinkedHashSet różni się tu od zwykłego HashSet?


        //Dana jest lista List<Integer> numbers zawierająca liczby od 1 do 20.
        // Usuń z niej wszystkie liczby podzielne przez 3, iterując po liście.
        // Zaimplementuj to dwoma sposobami: błędnym (żeby zobaczyć ConcurrentModificationException) i
        // poprawnym (przy użyciu Iterator lub removeIf).

        //2. Własna implementacja List na tablicy (poziom: junior/mid)
        //Zaimplementuj prostą klasę MyArrayList<T> z metodami:
        // add(T element), get(int index),
        // remove(int index), size().
        // Lista powinna automatycznie zwiększać swoją wewnętrzną tablicę,
        // gdy się zapełni (np. dwukrotnie). Dodatkowo: napisz testy sprawdzające zachowanie przy get() z indeksem poza zakresem.

        //3. Scalanie i deduplikacja dwóch list (poziom: mid)
        //Mając dwie listy List<String> list1 i List<String> list2,
        // napisz metodę zwracającą nową listę zawierającą unikalne elementy z obu list,
        // zachowując kolejność pierwszego wystąpienia. Zaimplementuj to w trzech wariantach:
        // pętlami + LinkedHashSet, przy użyciu Stream API (distinct()),
        // oraz bez żadnej kolekcji pomocniczej (czysta iteracja zagnieżdżona) — porównaj złożoność czasową każdego podejścia.

        //4. Sortowanie listy obiektów według wielu kryteriów (poziom: mid)
        //Dana jest lista obiektów Employee (pola: name, department, salary). Posortuj listę najpierw według działu (alfabetycznie),
        // a w ramach działu — według wynagrodzenia (malejąco).
        // Zrób to dwoma sposobami: Comparator.comparing().thenComparing()
        // oraz klasyczną implementacją Comparator<Employee>.

        //5. Wykrywanie cyklicznego przesunięcia listy / rotacja (poziom: mid/senior)
        //Napisz metodę rotate(List<Integer> list, int k), która przesuwa elementy listy o k miejsc w prawo (np. [1,2,3,4,5] przesunięte o k=2 daje [4,5,1,2,3]). Wymagania:
        //
        //działa dla k większego niż rozmiar listy,
        //działa „w miejscu" (bez tworzenia nowej listy) — wskazówka: zastanów się nad odwracaniem fragmentów (Collections.reverse),
        //porównaj złożoność tego podejścia z naiwnym (tworzenie nowej listy).

//4. Sortowanie listy obiektów według wielu kryteriów (poziom: mid)
//        //Dana jest lista obiektów Employee (pola: name, department, salary). Posortuj listę najpierw według działu (alfabetycznie),
//        // a w ramach działu — według wynagrodzenia (malejąco).

    }

    public static List<Employee> posortowanaLista(List<Employee> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getSalary, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    public static List<String> jednaListaBezDuplikatow(List<List<String>> listy) {
        return Optional.ofNullable(listy)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> scalBezDuplikatowLinkedHashSet(List<String> list1, List<String> list2) {
        Set<String> wynik = new LinkedHashSet<>();
        for (String s : list1) {
            wynik.add(s);
        }
        for (String s : list2) {
            wynik.add(s);
        }
        return new ArrayList<>(wynik);
    }

    public static List<Integer> listaBezPodzielnych(List<Integer> lista, int podzielnaPrzez) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(liczba -> liczba % podzielnaPrzez != 0)
                .collect(Collectors.toList());
    }

    public static List<Integer> bezduplikatow(List<Integer> lista ) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Produkt> listaTowarowRosnaco(List<Produkt> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingDouble(Produkt::getCena))
                .collect(Collectors.toList());
    }

    public static List<String> listaZImionami(List<String> lista, int podajIndex) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(lista.get(podajIndex))) {
                lista.remove(i);
                lista.add("Ewa");
            }
        }
        return lista;
    }

    public static List<Integer> listaLiczbParzystych(List<Integer> listaLiczb) {
        return Optional.ofNullable(listaLiczb)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

}
