package com.java.course.com.lesson88;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //List.of() - lista niemodyfikowalna
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = new ArrayList<>(List.of(1, 2,2, 3, 4, 5));
        //list.remove(5); //UnsupportedOperationException
        list2.add(123); //UnsupportedOperationException
        Integer toRemove = 123;
        list2.remove(toRemove);
        System.out.println(list2);
        System.out.println(listNieparzystych(list2));
        Integer a = 50;
        Integer b = 50;
        System.out.println(a == b); //true
        System.out.println(a.equals(b)); // true
        System.out.println();
        System.out.println();
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // true

        Map<String,Integer> mapa = new HashMap<>();
        mapa.put("Radek",2);
        mapa.put("Marek",3);
        mapa.put("Ola",5);
        System.out.println(zamienioneWartosci(mapa));

        List<Pracownik> pracownicy = List.of(
                new Pracownik("Anna", "IT", 8000),
                new Pracownik("Piotr", "IT", 9500),
                new Pracownik("Maria", "HR", 6000),
                new Pracownik("Tomasz", "HR", 6500),
                new Pracownik("Kasia", "Sprzedaż", 7200),
                new Pracownik("Marek", "Sprzedaż", 7800)
        );

        List<Integer> liczby = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        Optional<Integer> wynik = liczby.stream()
                .peek(n -> System.out.println("peek: " + n))
                .filter(n -> n % 3 == 0)
                .findFirst();

        System.out.println("wynik: " + wynik.get());


        List<Zamowienie> zamowienia = List.of(
                new Zamowienie("Nowak", 150.0),
                new Zamowienie("Kowalski", 300.0),
                new Zamowienie("Wiśniewski", 89.5),
                new Zamowienie("Nowak", 220.0)
        );

        List<Ksiazka> ksiazki = List.of(
                new Ksiazka("Wiedźmin", "Sapkowski", 1994),
                new Ksiazka("Lód", "Dukaj", 2007),
                new Ksiazka("Pan Tadeusz", "Mickiewicz", 1834),
                new Ksiazka("Inne pieśni", "Dukaj", 2003)
        );



    }

    //Mając tę samą listę ksiazki, zbierz je do Map<String, Integer>,
    // ie kluczem jest tytuł, a wartością rok wydania.
    public static Map<String, Integer> tytulNaRok(List<Ksiazka> ksiazki) {
        return Optional.ofNullable(ksiazki)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(
                        ksiazka -> ksiazka.getTytul(),
                        ksiazka -> ksiazka.getRokWydania(),
                        (istniejacy, nowy) -> istniejacy
                ));
    }



    //Posortuj listę najpierw po autorze (rosnąco alfabetycznie),
    // a przy tym samym autorze — po roku wydania (malejąco). Zwróć List<Ksiazka>.
    public static List<Ksiazka> posortujKsiazki(List<Ksiazka> ksiazki) {
        return Optional.ofNullable(ksiazki)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Ksiazka::getAutor).thenComparing(Ksiazka::getRokWydania).reversed())
                .collect(Collectors.toList());
    }


    //Mając tę samą listę zamowienia, napisz metodę, która dzieli zamówienia na dwie grupy: te z kwotą >= 200 i te poniżej —
    // używając Collectors.partitioningBy(). Wynik ma być Map<Boolean, List<Zamowienie>>.

    public static Map<Boolean, List<Zamowienie>> podzielZamowienia(List<Zamowienie> zamowienia) {
        return Optional.ofNullable(zamowienia)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.partitioningBy(
                        zamowienie -> zamowienie.getKwota() >= 200
                ));
    }


    //Napisz metodę, która za pomocą reduce() znajduje zamówienie o najwyższej kwocie i zwraca je jako Optional<Zamowienie>.

    public static Optional<Zamowienie> najwiekszeZamowienie(List<Zamowienie> zamowienia) {
       return Optional.ofNullable(zamowienia)
               .orElse(Collections.emptyList())
               .stream()
               .filter(Objects::nonNull)
                .reduce((z1, z2) -> z1.getKwota()> z2.getKwota() ? z1 : z2);
    }




    /*
    Walidacja w konstruktorze kanonicznym (tzw. compact constructor) — rzuć IllegalArgumentException, jeśli:

    cena jest ujemna,
    ilosc jest ujemna,
    nazwa jest null lub pusta (po trim())


    Dodaj metodę instancyjną wartoscCalkowita(), która zwraca cena * ilosc.
    Dodaj dodatkowy konstruktor pomocniczy (overloaded), który przyjmuje tylko nazwa i cena, a ilosc domyślnie ustawia na 1.
    Dodaj statyczną metodę fabrykującą Produkt.pusty(String nazwa), która tworzy produkt z cena=0, ilosc=0.
     */
    record Produkt(String nazwa, double cena, int ilosc) {
        public Produkt {
            if (cena < 0) {
                throw new IllegalArgumentException("Cena nie może być ujemna");
            }
            if (ilosc < 0) {
                throw new IllegalArgumentException("Ilosc nie może być ujemna");
            }
            if (nazwa == null || nazwa.trim().isEmpty()) {
                throw new IllegalArgumentException("Nazwa nie może być nullem");
            }
        }
        public double wartoscCalkowita() {
            return cena * ilosc;
        }

        public Produkt(String nazwa, double cena) {
            this(nazwa, cena, 1);
        }

        public static Produkt pusty(String nazwa) {
            return new Produkt(nazwa, 0, 0);
        }
    }





    public static Map<String, Double> sredniaPensjaWDziale(List<Pracownik> pracownicy) {
        return Optional.ofNullable(pracownicy)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Pracownik::getDzial,
                        Collectors.averagingDouble(Pracownik::getPensja)
                ));
    }


    //napisz funkcje ktora przyjmie Map<String,Integer> i zwroci Map<Integer,String> z zamienionymi kluczami na wartosci
    public static Map<Integer,String> zamienioneWartosci(Map<String,Integer> mapa) {
        Map<Integer,String> nowaMapa = new HashMap<>();
        for (Map.Entry<String,Integer> wartosc : mapa.entrySet()) {
            nowaMapa.put(wartosc.getValue(),wartosc.getKey());
        }
        return nowaMapa;
    }
    //napisz funkcje ktora zwroci n-ta najpopularniejsza liczbe 1,1,1,1,1,2,2,2,2,3,3 -> 2
    public static Integer nTaNajpopularniejsza(List<Integer> list, int nTySzukany) {
        Map<Integer, Long> mapa = list.stream()
                .collect(Collectors.groupingBy(liczba -> liczba,
                        Collectors.counting()));

        return mapa.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .skip(nTySzukany - 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    //napisz funkcje ktora usunie wszystkie liczby parzyste za pomoca petli for
    public static List<Integer> listNieparzystych(List<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) % 2 == 0) {
                lista.remove(lista.get(i));
                i--;
            }
        }
        return lista;
    }
}
