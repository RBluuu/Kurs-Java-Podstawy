package com.java.course.com.lesson81;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
        public int wiek() {
        LocalDate dzisiaj = LocalDate.now();
        int wiekOsoby = Period.between(this.getBirtdate(), dzisiaj).getYears();
        return wiekOsoby;
    }
         */

        Person p5 = new Person("Marek", "Kamiński", LocalDate.of(1988, 7, 30), "Inżynier");
        Person p6 = new Person("Marek", "XXX", LocalDate.of(1988, 7, 30), "Inżynier");


        List<Person> lista = new ArrayList<>();
        lista.add(p5);
        lista.add(p6);
        lista.add(null);
        System.out.println(obliczanieWieku(lista));
        System.out.println(obliczanieWieku(null));

        System.out.println(sumaLiterWNazwisku(lista));

        System.out.println(grupowanie(lista));

        String s1 = "Radek";
        String s2 = "Rower";
        String s3 = "Aleksander";

        List<String> listaWyrazow = new ArrayList<>();
        listaWyrazow.add(s1);
        listaWyrazow.add(s2);
        listaWyrazow.add(s3);

        System.out.println(odwoconyString(listaWyrazow));



    }
    //6. Znajdź pierwszy string, który ma więcej niż 10 znaków.
    public static String pierwszyWiekszyNiz10Znakow(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(slowo -> slowo.length() > 10)
                .findFirst()
                .orElse("");
    }

    //13. Sprawdź czy wszystkie stringi mają długość większą niż 3.
    public static boolean wiekszeNiz3(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .allMatch(slowo -> slowo.length() > 3);
    }
    //Usuń duplikaty i posortuj wynik malejaco
    public static List<Integer> bezDuplikatowPosorotwanaLista(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
    //21. Znajdź wszystkie liczby podzielne przez 7.
    public static List<Integer> podzielnePrzez7(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(liczba -> liczba % 7 == 0)
                .collect(Collectors.toList());
    }

    //25. Znajdź drugi najmniejszy element w liście.
    public static Optional<Integer> drugiNajmniejszyElementZListy(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted()
                .skip(1)
                .findFirst();

    }

    public static double obliczanieWieku(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(Person::wiek)
                .average()
                .orElse(0);
    }


    public static int sumaLiterWNazwisku(List<Person> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(Person::getLastName)
                .filter(lastName -> lastName.length() > 5)
                .mapToInt(String::length)
                .sum();
    }

    public static Map<Character,List<Person>> grupowanie(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        osoba -> osoba.getLastName().charAt(0)
                ));

    }
    public static Map<Integer,List<Person>> grupowaniePoDlugosciNazwiska(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        osoba -> osoba.getLastName().length()
                ));
    }

    public static List<StringBuilder> odwoconyString(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(slowo -> new StringBuilder(slowo).reverse())
                .collect(Collectors.toList());
    }

    //przyjmij liste list intow i oblicz sume elementow
    public static int sumaElementowZList(List<List<Integer>> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .mapToInt(Integer::intValue)
                .sum();
    }

    //1. Mając listę liczb całkowitych, znajdź wszystkie liczby parzyste i zwróć je jako nową listę.
    public static List<Integer> listaLiczbParzystych(List<Integer> listaLiczb) {
        return Optional.ofNullable(listaLiczb)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(liczba -> liczba % 2 == 0)
                .collect(Collectors.toList());
    }

    //2. Z listy stringów usuń wszystkie napisy krótsze niż 5 znaków.
    public static List<String> listaStringowWiekszychNiz5Znakow(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(slowo -> slowo.length() >= 5)
                .collect(Collectors.toList());
    }

    //3. Zamień listę stringów na listę ich długości.
    public static List<Integer> stingiNaIntiger(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(String::length)
                .collect(Collectors.toList());
    }

    //4. Znajdź największą liczbę w liście używając stream.
    public static int najwiekszyIntiger(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .max(Integer::compareTo)
                .orElse(0);
    }

    //5. Sprawdź czy w liście istnieje liczba większa niż 100.
    public static boolean czyIstniejeWiekszaLiczbaOd100(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .anyMatch(liczba -> liczba > 100);
    }

    //6. Policz ile elementów w liście jest większych niż 50.
    public static long iloscElementowWiekszychOd50(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(liczba -> liczba > 50)
                .count();
    }

    //7. Zamień wszystkie stringi w liście na wielkie litery.
    public static List<String> stringiZWielkimiLiterami(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    //8. Zsumuj wszystkie liczby w liście.
    public static int sumaWszystkichLiczbZListy(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();
    }

    //9. Znajdź pierwszy element większy niż 10 (Optional).
    public static Optional<Integer> pierwszyWiekszyOd10NaLiscie(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(liczba -> liczba > 10)
                .findFirst();
    }

    //10. Usuń duplikaty z listy.
    public static List<Integer> usuwanieDuplikatowZListy(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    //11. Posortuj listę liczb rosnąco.
    public static List<Integer> posortowanaListaLiczbRosnaco(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.toList());
    }

    //12. Posortuj listę stringów malejąco po długości.
    public static List<String> posortowanaListaStringow(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted((s1, s2) -> Integer.compare(s2.length(), s1.length()))
                .collect(Collectors.toList());
    }

    //13. Z listy obiektów Person (name, age) wybierz tylko osoby pełnoletnie.
    public static List<Person> listaTylkoPelnoletnich(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(pelnoletni -> pelnoletni.getWiek() >= 18)
                .collect(Collectors.toList());
    }

    //14. Z listy Person zwróć listę ich imion.
    public static List<String> listaImion(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(Person::getLastName)
                .collect(Collectors.toList());
    }

    //15. Znajdź najstarszą osobę z listy Person.
    public static Person najstarszaOsobaZListy(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(Person::getWiek))
                .orElse(null);
    }

    //16. Pogrupuj osoby według wieku (Map<Integer, List<Person>>).
    public static Map<Integer,List<Person>> wedlugWieku(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Person::getWiek));
    }

    //17. Policz ile osób ma dany wiek (Map<Integer, Long>)
    public static Map<Integer,Long> podanyWiek(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Person::getWiek,
                        Collectors.counting()));
    }

    //18. Znajdź średni wiek osób.
    public static int sredniaWieku(List<Person> lista) {
        return (int) Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(Person::getWiek)
                .average()
                .orElse(0);
    }

    //19. Połącz listę stringów w jeden string oddzielony przecinkami.
    public static String jedenString(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", "));
    }

    //20. Spłaszcz listę list liczb (List<List<Integer>>) do jednej listy.
    public static List<Integer> listaZList(List<List<Integer>> listaList) {
        return Optional.ofNullable(listaList)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
    //21. Znajdź wszystkie unikalne słowa w liście zdań.
    public static List<String> wyszukiwanieSlowa(List<String> listaZdan) {
        return Optional.ofNullable(listaZdan)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMap(zdanie -> Arrays.stream(zdanie.split("\\s+")))
                .map(String::toLowerCase)
                .filter(slowo -> !slowo.isEmpty())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    //22. Z listy stringów wybierz te, które zaczynają się na literę 'A'.
    public static List<String> slowaNaA(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(slowo -> slowo.startsWith("A"))
                .collect(Collectors.toList());
    }

    //23. Znajdź drugi największy element w liście liczb.
    public static int najwiekszyElementZListy (List<Integer> lista) {
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
    public static Map<Boolean, List<Integer>> grupowanieNaParzysteINieparzyste (List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.partitioningBy(liczba -> liczba % 2 == 0));
    }

    //25. Znajdź wszystkie liczby pierwsze w liście.
    public static List<Integer> liczbyPierwsze(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(Main::czyPierwsza)
                .collect(Collectors.toList());
    }

    private static boolean czyPierwsza(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //26. Z listy stringów usuń null-e i puste wartości.
    public static List<String> usuwanieNulliIPustychwarosci(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> !s.isBlank())
                .collect(Collectors.toList());
    }

    //27. Sprawdź czy wszystkie liczby w liście są dodatnie.
    public static boolean sprawdzanieCzySaDodatnie(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .allMatch(liczba -> liczba > 0);
    }

    //28. Znajdź najkrótszy string w liście.
    public static String najkrotszyString(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparingInt(String::length))
                .orElse(null);
    }

    //29. Z listy Person stwórz mapę (name -> age).
    public static Map<String,Integer> mapaImieIWiek(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(
                        Person::getFirstName,
                        Person::getWiek
                ));
    }


    //30. Zlicz wystąpienia każdego stringa w liście (Map<String, Long>)
    public static Map<String,Long> iloscWysapienStringow(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        slowo -> slowo,
                        Collectors.counting()
                ));
    }

    //31. Posortuj osoby po wieku, a następnie po imieniu.
    public static List<Person> sortowaniePoWieku(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator
                .comparingInt(Person::getWiek)
                .thenComparing(Person::getFirstName))
                .collect(Collectors.toList());
    }

    //32. Znajdź top 3 największe liczby.
    public static List<Integer> top3Liczb(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
    }

    //33. Połącz dwie listy w jedną używając stream.
    public static List<Integer> polaczonaLista(List<Integer> lista1, List<Integer> lista2) {
        return Stream.concat(
                        Optional.ofNullable(lista1)
                                .orElse(Collections.emptyList())
                                .stream(),
                        Optional.ofNullable(lista2)
                                .orElse(Collections.emptyList())
                                .stream()
                )
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    //34. Zamień listę liczb na mapę (liczba -> jej kwadrat).
    public static Map<Integer,Integer> mapaLiczbILiczbaDoKwadratu(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(
                        liczba -> liczba,
                        liczba -> liczba * liczba
                ));
    }

    //35. Sprawdź czy lista zawiera duplikaty (bez użycia Set bezpośrednio).
    /*public static boolean czyZawieraDuplikaty(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)

    }

     */
    public static boolean hasDuplicates(List<Integer> list){
        return list.size() == Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .distinct()
                .toList()
                .size();
    }

    //36. Z listy zdań wyciągnij wszystkie słowa i posortuj alfabetycznie.
    public static List<String> sortowanieAlfabetyczne(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .sorted()
                .collect(Collectors.toList());
    }

    //37. Znajdź element, który pojawia się najczęściej w liście.
    public static String elementyPojawiajaceSieNajczesciej(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        slowo -> slowo,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }



    //38. Zamień listę stringów na mapę (pierwsza litera -> lista stringów).
    public static Map<Character,List<String>> zmianaListyNaMape(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> !s.isBlank())
                .collect(Collectors.groupingBy(
                        s ->  Character.toUpperCase(s.charAt(0))
                ));
    }

    //39. Znajdź wszystkie liczby podzielne przez 3 i 5.
    public static List<Integer> liczbyPodzielnePrzez3i5(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(liczba -> liczba % 3 == 0 && liczba % 5 == 0)
                .collect(Collectors.toList());
    }


    //40. Z listy Person znajdź osoby w przedziale wieku 20–30 i posortuj je malejąco
    public static List<Person> ludzieWPrzedziale20i30(List<Person> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(osoba -> osoba.getWiek() >= 20 && osoba.getWiek() <= 30)
                .sorted(Comparator.comparing(Person::getWiek).reversed())
                .collect(Collectors.toList());
    }



}
//3. Zamień listę stringów na listę stringów odwróconych (np. "ala" -> "ala", "kot" -> "tok").

//pogrupuj osoby po dlugosci nazwiska
//Napisz fucknje ktora pogrupuje osoby po ich inicjalach (pierwsza litera nazwiska)//
//N - Nowak,Nowakowska K-Kowalski,Kurek

//Napisz funkcje ktora obliczy sume ilosci liter osob z nazwiskiem dluzszym niz 5 liter


//Napisz funkcje ktora oblicza sredni wiek u ludzi za pomoca streamow

//1. Mając listę liczb całkowitych, znajdź wszystkie liczby parzyste i zwróć je jako nową listę.

//2. Z listy stringów usuń wszystkie napisy krótsze niż 5 znaków.

//3. Zamień listę stringów na listę ich długości.

//4. Znajdź największą liczbę w liście używając stream.

//5. Sprawdź czy w liście istnieje liczba większa niż 100.

//6. Policz ile elementów w liście jest większych niż 50.

//7. Zamień wszystkie stringi w liście na wielkie litery.

//8. Zsumuj wszystkie liczby w liście.

//9. Znajdź pierwszy element większy niż 10 (Optional).

//10. Usuń duplikaty z listy.

//11. Posortuj listę liczb rosnąco.

//12. Posortuj listę stringów malejąco po długości.

//13. Z listy obiektów Person (name, age) wybierz tylko osoby pełnoletnie.

//14. Z listy Person zwróć listę ich imion.

//15. Znajdź najstarszą osobę z listy Person.

//16. Pogrupuj osoby według wieku (Map<Integer, List<Person>>).

//17. Policz ile osób ma dany wiek (Map<Integer, Long>).

//18. Znajdź średni wiek osób.

//19. Połącz listę stringów w jeden string oddzielony przecinkami.

//20. Spłaszcz listę list liczb (List<List<Integer>>) do jednej listy.

//21. Znajdź wszystkie unikalne słowa w liście zdań.

//22. Z listy stringów wybierz te, które zaczynają się na literę 'A'.

//23. Znajdź drugi największy element w liście liczb.

//24. Podziel liczby na parzyste i nieparzyste (partitioningBy).

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