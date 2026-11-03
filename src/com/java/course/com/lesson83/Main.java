package com.java.course.com.lesson83;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(List.of(2, 1, 2, 3, 4, 5, 6, 7, 100));
        System.out.println(listaBezNieparzystychv2(list));
        System.out.println();
        System.out.println(liczbaZNajwiekszaLiczbaDzielnikow(list));
        System.out.println();
        System.out.println(Arrays.toString(zadanie(list, 4)));
        List<Integer> list2 = new ArrayList<>(List.of(1, 2, 3, 4, 1, 2, 3, 4, 5, 1, 2, 3, 2));
        System.out.println(rosnacaSekwencja(list2));
        System.out.println();
        System.out.println("Zadanie 1");
        System.out.println(najczesciejWystepujacaLiczba(list2));

    }

    //napisz funkcje ktora przyjmie liste i usunie z niej nieparzyste elementy
    public static List<Integer> listaBezNieparzystych(List<Integer> list) {
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                list2.add(i);
            }
        }
        return list2;
    }

    public static List<Integer> listaBezNieparzystychv2(List<Integer> list) {
        return list.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
    }

    //napisz funkcje ktora z listy liczb zwroci liczbe z najwieksza iloscia dzielnikow
    public static Integer liczbaZNajwiekszaLiczbaDzielnikow(List<Integer> list) {
        int szukanaLiczba = list.get(0);
        int max = liczbaDzielnikow(szukanaLiczba);
        for (int liczba : list) {
            int liczbaDzielnikow = liczbaDzielnikow(liczba);
            if (liczbaDzielnikow > max) {
                max = liczbaDzielnikow;
                szukanaLiczba = liczba;
            }
        }
        return szukanaLiczba;
    }

    public static int liczbaDzielnikow(int x) {
        int ilosc = 0;
        for (int i = 1; i < x; i++) {
            if (x % i == 0) {
                ilosc++;
            }
        }
        return ilosc;
    }

    //napisz funkcje ktora przyjmie liste liczb i zwroci indexy 2 liczb ktore dodaja sie do podanej sumy, jezeli nie ma
    //takich liczb to zwroc -1,-1
    //([1,2,3,4],5)
    //[0,3]
    public static int[] zadanie(List<Integer> lista, int x) {
        for (int i = 0; i < lista.size(); i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i) + lista.get(j) == x) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    //Napisz funkcję zwracającą najdłuższą rosnącą sekwencję liczb
    //[1,2,3,4,1,2,3] -> 1,2,3,4
    //2,4,8,10,7,6 -> 2,4,8,10
    //1,2,3,4,1,2,3,4,5,-> 1,2,3,4,

    public static List<Integer> rosnacaSekwencja(List<Integer> list) {
        int bestLength = 1;
        int bestStart = 0;
        int currentLength = 1;
        int currentStart = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) < list.get(i)) {
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
        if (currentLength > bestLength) {
            bestLength = currentLength;
            bestStart = currentStart;
        }
        return list.subList(bestStart, bestStart + bestLength);
    }

    //napisz funkcje ktora obliczy ile jest liczb podzielnych przez 3  w liscie
    public static int listaPodzielnychPrzez3(List<Integer> list, int podzielna) {
        int ilosc = 0;
        for (int liczba : list) {
            if (liczba % podzielna == 0) {
                ilosc++;
            }
        }
        return ilosc;
    }

    //napisz funkcje ktora sprawdzi czy lista jest posortowana rosnaco
    public static boolean czyPosortowana(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    //Napisz funkcję zwracającą najczęściej występującą liczbę.
    public static int najczesciejWystepujacaLiczba(List<Integer> lista) {
        int najczesciejWystepujaca = lista.get(0);
        int maxWystapien = 0;
        for (int i = 0; i < lista.size(); i++) {
            int aktualnaLiczba = lista.get(i);
            int licznikWystapien = 0;
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j) == aktualnaLiczba) {
                    licznikWystapien++;
                }
            }
            if (licznikWystapien > maxWystapien) {
                maxWystapien = licznikWystapien;
                najczesciejWystepujaca = aktualnaLiczba;
            }
        }
        return najczesciejWystepujaca;
    }

    //Napisz funkcję zwracającą liczbę pierwszą o największej wartości.
    public static int liczbaZNajwiekszaWartoscia(List<Integer> list) {
        int szukanaLiczba = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            int liczba = 0;
            if (list.get(i) % 1 == 0 || list.get(i) % list.get(i) == 0) {
                liczba = list.get(i);
                if (liczba > liczba + 1) {
                    szukanaLiczba = liczba;
                }
            }
        }
        return szukanaLiczba;
    }

    /*
    int szukanaLiczba = -1; // -1 oznacza "nie znaleziono żadnej liczby pierwszej"

    for (int i = 0; i < list.size(); i++) {
        int liczba = list.get(i);

        if (czyPierwsza(liczba) && liczba > szukanaLiczba) {
            szukanaLiczba = liczba;
        }
    }

    if (szukanaLiczba == -1) {
        throw new RuntimeException("Brak liczb pierwszych na liście");
    }

    return szukanaLiczba;
}

     */

    private static boolean czyPierwsza(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //Napisz funkcję usuwającą wszystkie liczby pierwsze.
    public static List<Integer> listaBezPierwszych(List<Integer> list) {
        List<Integer> nowa = new ArrayList<>();
        for (int liczba : list) {
            if (!czyPierwsza(liczba)) {
                nowa.add(liczba);
            }
        }
        return nowa;
    }

    //Napisz funkcję zwracającą wszystkie liczby doskonałe z listy.
    public static boolean czyDoskonala(int n) {
        if (n < 2) {
            return false;
        }
        int suma = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                suma += i;
                if (i != n / i) {
                    suma += n / i;
                }
            }
        }
        return suma == n;
    }


    //Napisz funkcję zwracającą liczbę z największą sumą cyfr.
    public static int liczbaZNajwiekszaSuma(List<Integer> listaLiczba) {
        int liczbaZNajwiekszaIlosciaLiczb = listaLiczba.get(0);
        int licznik = sumaCyfr(liczbaZNajwiekszaIlosciaLiczb);
        for (int i = 0; i < listaLiczba.size(); i++) {
            int suma = sumaCyfr(listaLiczba.get(i));
            if (suma > licznik) {
                licznik = suma;
                liczbaZNajwiekszaIlosciaLiczb = listaLiczba.get(i);
            }
        }
        return liczbaZNajwiekszaIlosciaLiczb;
    }

    private static int sumaCyfr(int n) {
        n = Math.abs(n);
        int suma = 0;
        while (n > 0) {
            suma += n % 10;
            n /= 10;
        }
        return suma;
    }

    //Napisz funkcję grupującą liczby według reszty z dzielenia przez 3.
    public static Map<Integer, List<Integer>> grupujWedlugReszty(List<Integer> lista, int podzielnaLiczba) {
        Map<Integer, List<Integer>> mapa = new HashMap<>();
        mapa.put(0, new ArrayList<>());
        mapa.put(1, new ArrayList<>());
        mapa.put(2, new ArrayList<>());

        for (int liczba : lista) {
            int reszta = Math.abs(liczba % podzielnaLiczba);
            mapa.get(reszta).add(liczba);
        }
        return mapa;
    }

    //Napisz funkcję znajdującą parę liczb dającą największą sumę.
    public static Map<Integer, Integer> paraZNajwieszkaSuma(List<Integer> lsita) {
        Map<Integer, Integer> mapa = new HashMap<>();
        int liczbaNR1 = lsita.get(0);
        int liczbaNR2 = lsita.get(0);
        int sumaNajwieksza = liczbaNR1 + liczbaNR2;
        for (int i = 0; i < lsita.size(); i++) {
            for (int j = 1; j < lsita.size(); j++) {
                int suma = lsita.get(i) + lsita.get(j);
                if (suma > sumaNajwieksza) {
                    sumaNajwieksza = suma;
                    liczbaNR1 = lsita.get(i);
                    liczbaNR2 = lsita.get(j);
                }
            }
        }
        mapa.put(liczbaNR1, liczbaNR2);
        return mapa;
    }

    /* Zadanie nr1:
    Masz listę imion. Zwróć listę imion, które mają więcej niż 4 litery,
    zapisanych wielkimi literami, posortowanych alfabetycznie.
    List<String> imiona = List.of("Anna", "Bartosz", "Ola", "Krzysztof", "Jan", "Monika");
     */

    public static List<String> listaImionDluzszychNiz4Litery(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(imie -> imie.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
    }

    /*
    Masz listę liczb całkowitych. Zwróć sumę kwadratów
    tylko liczb nieparzystych.
    List<Integer> liczby = List.of(1, 2, 3, 4, 5, 6, 7);
     */
    public static int listaLiczbNieparzystychPodniesionychDoKwadratu(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(liczba -> liczba % 2 !=0)
                .mapToInt(liczba -> liczba * liczba)
                .sum();
    }

    /*
    Masz listę słów. Pogrupuj je według długości słowa
    (klucz = długość, wartość = lista słów).
    List<String> slowa = List.of("kot", "pies", "ryba", "lis", "wilk", "as");
     */

    public static Map<Integer,List<String>> mapaDoZadania(List<String> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.groupingBy(
                        String::length
                ));
    }

    /*
    Masz listę list liczb. Zwróć jedną listę zawierającą
    tylko unikalne liczby, posortowane rosnąco.
    List<List<Integer>> listy = List.of(
        List.of(3, 1, 4, 1),
        List.of(5, 9, 2, 6),
        List.of(5, 3, 5));
     */
    public static List<Integer> splaszczonaLista(List<List<Integer>> listy) {
        return Optional.ofNullable(listy)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    /*
    Masz listę pracowników. Znajdź średnią pensję pracowników
    z działu "IT" którzy zarabiają więcej niż 5000.
    record Pracownik(String imie, String dzial, double pensja) {}
    List<Pracownik> pracownicy = List.of(
        new Pracownik("Anna", "IT", 6000),
        new Pracownik("Bartek", "HR", 4500),
        new Pracownik("Celina", "IT", 4000),
        new Pracownik("Darek", "IT", 7000)
    );
     */

    public static double sredniaPensjaPowyzej(List<PracownikIT> listaPracownikow, int powyzejSredniej) {
        return Optional.ofNullable(listaPracownikow)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(osoba -> osoba.getDzial().equals("IT"))
                .filter(osoba -> osoba.getPensja() > powyzejSredniej)
                .mapToDouble(PracownikIT::getPensja)
                .average()
                .orElse(0.0);
    }

    /*
    Masz listę transakcji. Sprawdź czy WSZYSTKIE transakcje
    na kwotę powyżej 1000 są typu "PRZELEW".
    Zwróć boolean.

    record Transakcja(String typ, double kwota) {}

    List<Transakcja> transakcje = List.of(
        new Transakcja("PRZELEW", 1500),
        new Transakcja("PRZELEW", 2000),
        new Transakcja("BLIK", 500),
        new Transakcja("PRZELEW", 3000)
    );
     */
    public static boolean sprawdzanieRodzajuTransakcji(List<Transakcja> list, String przelewAlboBlik) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(t -> t.getKwota() > 1000)
                .allMatch(t -> t.getTyp().equals("PRZELEW"));
    }
    /*Zadanie 2 — flatMap
    Masz listę zamówień, każde zawiera listę produktów.
    Zwróć listę wszystkich produktów posortowanych alfabetycznie
    bez duplikatów.

    record Zamowienie(String klient, List<String> produkty) {}

    List<Zamowienie> zamowienia = List.of(
        new Zamowienie("Anna", List.of("chleb", "mleko", "jajka")),
        new Zamowienie("Bartek", List.of("mleko", "maslo", "chleb")),
        new Zamowienie("Celina", List.of("jajka", "ser")));
     */
    public static List<Produkt> jednaLista(List<Zamowienie> listyZamowien) {
        return Optional.ofNullable(listyZamowien)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMap(zamowienie -> zamowienie.getListaProduktow().stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    /*
    Zadanie 3 — reduce zamiast sum
    Masz listę liczb. Zwróć iloczyn (wynik mnożenia)
    wszystkich liczb nieparzystych.
    List<Integer> liczby = List.of(1, 2, 3, 4, 5, 6, 7);
     */

    public static int wynikLiczbNieparzystych(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(liczba -> liczba % 2 != 0)
                .reduce(1, (a, b) -> a * b);
    }



    /*
    Zadanie 2 — flatMap
Masz listę zamówień, każde zawiera listę produktów.
Zwróć listę wszystkich produktów posortowanych alfabetycznie
bez duplikatów.

record Zamowienie(String klient, List<String> produkty) {}

List<Zamowienie> zamowienia = List.of(
    new Zamowienie("Anna", List.of("chleb", "mleko", "jajka")),
    new Zamowienie("Bartek", List.of("mleko", "maslo", "chleb")),
    new Zamowienie("Celina", List.of("jajka", "ser"))
);

Zadanie 3 — reduce zamiast sum
Masz listę liczb. Zwróć iloczyn (wynik mnożenia)
wszystkich liczb nieparzystych.

List<Integer> liczby = List.of(1, 2, 3, 4, 5, 6, 7);

Zadanie 4 — Optional
Masz listę pracowników. Znajdź imię najlepiej zarabiającego
pracownika z działu "HR". Jeśli brak pracowników HR,
zwróć "Brak pracowników".

record Pracownik(String imie, String dzial, double pensja) {}

List<Pracownik> pracownicy = List.of(
    new Pracownik("Anna", "IT", 6000),
    new Pracownik("Bartek", "HR", 4500),
    new Pracownik("Celina", "HR", 5500),
    new Pracownik("Darek", "IT", 7000)
);

Zadanie 5 — groupingBy z counting
Masz listę słów. Zwróć mapę gdzie klucz to pierwsza litera słowa,
a wartość to liczba słów zaczynających się na tę literę.

List<String> slowa = List.of(
    "apple", "avocado", "banana", "blueberry", "cherry", "apricot"
);
     */

    /*
    source → filter → flatMap → map → distinct → sorted → limit/skip → collect/reduce

1. filter() — jak najwcześniej
java.filter(Objects::nonNull)       // najpierw null-check
.filter(t -> t.kwota() > 1000)  // potem logika biznesowa

Eliminujesz zbędne elementy zanim wykonasz na nich kosztowne operacje.


2. flatMap() — przed mapowaniem
java.flatMap(lista -> lista.stream()) // spłaszcz
.map(...)                         // potem transformuj

Musisz mieć pojedyncze elementy zanim zaczniesz je transformować.


3. map() — transformacja
java.map(Pracownik::pensja)    // wyciągnij pole
.map(String::toUpperCase)  // lub transformuj

Zmieniasz typ elementów — rób to po filtrowaniu, żeby nie transformować niepotrzebnych elementów.


4. distinct() — przed sortowaniem
java.distinct() // usuń duplikaty
.sorted()   // potem sortuj

Mniej elementów do posortowania = mniej operacji. Sortowanie jest kosztowne (O(n log n)).


5. sorted() — jak najpóźniej
java.sorted()                          // naturalny porządek
.sorted(Comparator.reverseOrder()) // lub odwrotny

Sortujesz tylko te elementy które przeszły przez wszystkie filtry.


6. limit() / skip() — po sortowaniu
java.sorted()
.limit(10)  // pierwsze 10 wyników
.skip(5)    // pomiń pierwsze 5

Najpierw posortuj, potem przytnij — inaczej dostaniesz losowe elementy.


7. Terminal operation — na końcu
collect()  → zwraca List, Map, Set
reduce()   → zwraca jedną wartość (iloczyn, suma własna logika)
sum()      → suma liczb
average()  → średnia, zwraca OptionalDouble
count()    → liczba elementów, zwraca long
allMatch() → boolean, czy wszystkie spełniają warunek
anyMatch() → boolean, czy chociaż jeden spełnia warunek
findFirst()→ zwraca Optional<T>
forEach()  → void, tylko efekty uboczne

Terminal operation kończy stream — nic po niej nie możesz dodać.


Najczęstszy błąd jaki popełniasz:
java// ŹLE — sortujesz wszystko, potem filtrujesz
.sorted()
.filter(...)
.collect()

// DOBRZE — filtrujesz najpierw, sortujesz mniej elementów
.filter(...)
.sorted()
.collect()
     */


}
/*
Napisz funkcję zwracającą najczęściej występującą liczbę. OK
Napisz funkcję zwracającą liczbę pierwszą o największej wartości.
Napisz funkcję usuwającą wszystkie liczby pierwsze.
Napisz funkcję zwracającą wszystkie liczby doskonałe z listy.
Napisz funkcję zwracającą liczbę z największą sumą cyfr.
Napisz funkcję zwracającą najdłuższą rosnącą sekwencję liczb.
Napisz funkcję grupującą liczby według reszty z dzielenia przez 3.
Napisz funkcję znajdującą parę liczb dającą największą sumę.
 */
