package com.java.course.com.lesson81;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PrzykladyStream {
    public static void main(String[] args) {
        /*
        Masz listę liczb.

        wybierz tylko liczby parzyste
        posortuj malejąco
        zwróć listę
         */

        List<Integer> numbers = List.of(5, 2, 8, 1, 10, 3);
        System.out.println(task1(numbers));

        /*
        Znajdź najdłuższy string w liście.
         */

        List<String> words = List.of("ala", "kot", "samochod", "dom");
        System.out.println(task2(words));

        /*
        płaszcz listę list (flatMap)

        Zadanie:
        Masz listę list liczb — zwróć jedną listę wszystkich elementów.
        */
        List<List<Integer>> data = List.of(
            List.of(1, 2),
            List.of(3, 4),
            List.of(5)
        );

        System.out.println(task3(data));

        /*
        Zadanie:
        Pogrupuj osoby według wieku.

        class Person {
            String name;
            int age;
        }
         */

        Person2 p1 = new Person2("Anna", 25);
        Person2 p2 = new Person2("Jan", 30);
        Person2 p3 = new Person2("Kasia", 22);
        Person2 p4 = new Person2("Marek", 25);

        List<Person2> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        System.out.println(task4(list));
        /*
        5. Znajdź duplikaty

        Zadanie (częsty hit na rozmowach):
        Znajdź elementy, które występują więcej niż raz.
         */
        List<Integer> numbers2 = List.of(1, 2, 3, 2, 4, 1, 5);




    }
    public static List<Integer> task1(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter( number -> number % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static String task2(List<String> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .max((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .stream().findFirst()
                .orElse(null);
    }

    public static List<Integer> task3(List<List<Integer>> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static Map<Integer, List<Person2>> task4(List<Person2> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Person2::getAge
                ));
    }

    public static List<Integer> task5(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    //Napisz program, który używa Supplier<String> do zwrócenia stałego tekstu „Hello Supplier”.
    public static Supplier<String> task1Suppleier(String text) {
        return () -> "Hello Supplier";
    }

    //Utwórz Supplier<Integer>, który za każdym wywołaniem zwraca losową liczbę od 1 do 100.
    public static Supplier<Integer> task2Supplier() {
        return () -> (int) (Math.random() * 100) + 1;
    }

    //Stwórz Supplier<LocalDateTime>, który zwraca aktualną datę i godzinę w momencie wywołania.
    public static Supplier<LocalDateTime> task3Suppleier() {
        return LocalDateTime::now;
    }

    //Zdefiniuj klasę User (z polami np. name i age), a następnie użyj Supplier<User>,
    // który tworzy nowy obiekt użytkownika z losowymi danymi.
    public static Supplier<Person2> task4Supplier() {
        return () -> {
            String[] names = {"Jan", "Anna", "Kasia", "Tomek"};
            String name = names[(int) (Math.random() * names.length)];

            int age = (int) (Math.random() * 100);

            return new Person2(name, age);
        };
    }

    //Napisz Consumer<String>, który wypisuje przekazany tekst na konsolę wielkimi literami.
    public static Consumer<String> task1Consumer() {
        return text -> System.out.println(text.toUpperCase());
    }

    //Utwórz Consumer<Integer>, który dla podanej liczby:
    //wypisuje jej kwadrat
    //oraz informację czy liczba jest parzysta
    public static Consumer<Integer> task2Consumer() {
        return number -> System.out.println("Kwadrat liczby = " + (number*number) + " czy liczba jest parzysta = " + ( number %2 == 0));
    }

    //Zdefiniuj klasę User (np. name, age), a następnie:
    //stwórz Consumer<User>, który wypisuje dane użytkownika w formacie:
    public static Consumer<Person2> task3Consumer() {
        return person -> System.out.println((person.getName()) + " " + (person.getAge()) + " lat");
    }
    //Stwórz dwa Consumer<String>:
    //
    //pierwszy wypisuje tekst
    //drugi wypisuje długość tekstu
    //
    //Następnie połącz je za pomocą andThen i uruchom dla jednego inputu.

    public static Consumer<String> task4Consumer() {
        Consumer<String> c1 = text -> System.out.println(text);
        Consumer<String> c2 = text -> System.out.println(text.length());

        return c1.andThen(c2);
    }







}
