package com.java.course.com.lesson84;

import java.util.*;
import java.util.stream.Collectors;

public class Main6 {
    public static void main(String[] args) {

    }
    //1. Mając listę liczb całkowitych, znajdź wszystkie liczby parzyste i zwróć je jako nową listę.
    public static List<Integer> liczbyParzyste(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    //2. Z listy stringów usuń wszystkie napisy krótsze niż 5 znaków.
    public static List<String> stringiDluzszeNiz(List<String> lista, int wymaganaDlugosc) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(n -> n.length() > wymaganaDlugosc)
                .collect(Collectors.toList());
    }

    //3. Zamień listę stringów na listę ich długości.
    public static List<Integer> stringiIchDlugosc(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(String::length)
                .collect(Collectors.toList());
    }

    //4. Znajdź największą liczbę w liście używając stream.
    public static Integer najwieszkaLiczbaNaLiscie(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Nie istnieje taka liczba"));
    }

    //5. Sprawdź czy w liście istnieje liczba większa niż 100.
    public static boolean czyIstniejeWieksza(List<Integer> lista,int wiekszaNiz) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .anyMatch(liczba -> liczba > wiekszaNiz);
    }

    //6. Policz ile elementów w liście jest większych niż 50.
    public static Map<Boolean, Long> iloscWiekszaNiz(List<Integer> lista, int wiekszaNiz) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        liczba -> liczba > wiekszaNiz,
                        Collectors.counting()
                ));
    }

    //7. Zamień wszystkie stringi w liście na wielkie litery.
    public static List<String> listaStringowZDuzaLiczba(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    //8. Zsumuj wszystkie liczby w liście.
    public static int sumaLiczb(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();
    }

    //9. Znajdź pierwszy element większy niż 10 (Optional).
    public static int sumaLiczb(List<Integer> lista, int wiekszyNiz) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(N -> N > wiekszyNiz)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Taki element nie istnieje"));
    }

    //10. Usuń duplikaty z listy.
    public static List<String> listaBezDuplikatow(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }
    //11. Posortuj listę liczb rosnąco.
    public static List<Integer> listaRosnaca(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }

    //12. Posortuj listę stringów malejąco po długości.
    public static List<String> listaStringowMalejaco(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
    }

    //13. Z listy obiektów Person (name, age) wybierz tylko osoby pełnoletnie.
    public static List<Person> tylkoPelnoletni(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(person -> person.getWiek() >= 18)
                .collect(Collectors.toList());
    }

    //14. Z listy Person zwróć listę ich imion.
    public static List<String> listaImion(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(Person::getName)
                .collect(Collectors.toList());
    }
    //15. Znajdź najstarszą osobę z listy Person.
    public static Person najstarszaOsoba(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(Person::getWiek))
                .orElseThrow(() -> new NoSuchElementException("Nie ma takiego"));
    }

    //16. Pogrupuj osoby według wieku (Map<Integer, List<Person>>).
    public static Map<Integer,List<Person>> listaOsobZWiekiem(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Person::getWiek
                ));
    }

    //17. Policz ile osób ma dany wiek (Map<Integer, Long>).
    public static Map<Integer,Long> liczbaOsobZWiekiem(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Person::getWiek,
                        Collectors.counting()
                ));
    }

    //18. Znajdź średni wiek osób.
    public static double sredniaWieku(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .mapToDouble(Person::getWiek)
                .average()
                .orElse(0);
    }

    //19. Połącz listę stringów w jeden string oddzielony przecinkami.
    public static String jedenString(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.joining(","));
    }

    //20. Spłaszcz listę list liczb (List<List<Integer>>) do jednej listy.
    public static List<Integer> jednaZKilkuList(List<List<Integer>> listy) {
        return Optional.ofNullable(listy)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    //21. Znajdź wszystkie unikalne słowa w liście zdań.
    public static List<String> listaUnikalnych(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    //22. Z listy stringów wybierz te, które zaczynają się na literę 'A'.
    public static List<String> listaStringowNaA(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(slowo -> slowo.toLowerCase().startsWith("a"))
                .collect(Collectors.toList());
    }

    //23. Znajdź drugi największy element w liście liczb.
    public static int drugaNajwieszkaLiczba(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0);
    }

    //24. Podziel liczby na parzyste i nieparzyste (partitioningBy).
    public static Map<Boolean,List<Integer>> mapaParzysteINieparzyste(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.partitioningBy(
                        parzysta -> parzysta % 2 == 0));
    }

    //25. Znajdź wszystkie liczby pierwsze w liście.

    //26. Z listy stringów usuń null-e i puste wartości.

    //27. Sprawdź czy wszystkie liczby w liście są dodatnie.

    //28. Znajdź najkrótszy string w liście.

    //29. Z listy Person stwórz mapę (name -> age).

    //30. Zlicz wystąpienia każdego stringa w liście (Map<String, Long>).

    //31. Posortuj osoby po wieku, a następnie po imieniu.

    //32. Znajdź top 3 największe liczby.

    //33. Połącz dwie listy w jedną używając stream.

    //34. Zamień listę liczb na mapę (liczba -> jej kwadrat).

    //35. Sprawdź czy lista zawiera duplikaty (bez użycia Set bezpośrednio).

    //36. Z listy zdań wyciągnij wszystkie słowa i posortuj alfabetycznie.

    //37. Znajdź element, który pojawia się najczęściej w liście.

    //38. Zamień listę stringów na mapę (pierwsza litera -> lista stringów).

    //39. Znajdź wszystkie liczby podzielne przez 3 i 5.

    //40. Z listy Person znajdź osoby w przedziale wieku 20–30 i posortuj je malejąco.
}
