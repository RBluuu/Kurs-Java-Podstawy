package com.java.course.com.lesson80;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("Jan", "Kowalski", LocalDate.of(1990, 5, 12), "Programista");
        Person p2 = new Person("Anna", "Nowak", LocalDate.of(1985, 8, 23), "Lekarz");
        Person p3 = new Person("Piotr", "Wiśniewski", LocalDate.of(2000, 1, 15), "Student");
        Person p4 = new Person("Katarzyna", "Wójcik", LocalDate.of(1995, 12, 3), "Nauczyciel");

        String zdanie = "To jest jest przykładowe zdanie zdanie z powtórzeniami powtórzeniami";
        System.out.println("Mapa do zadania nr2:");
        System.out.println(mapaWystapienSlow(zdanie));
        System.out.println();

        String[] listaUczniow = {"Radek", "Marek", "Darek", "Robert", "Mirek", "Rafal", "Damian", "Darek", "Wojtek", "Michal"};
        System.out.println("Zadanie nr3:");
        System.out.println(listaUczniowNaPodanaLitere(listaUczniow));
        System.out.println();

        List<Person> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);

        System.out.println("Zadanie nr1:");
        czlowiekIMapa(lista, 30);
        System.out.println();


        System.out.println(lista);
        System.out.println();

        System.out.println(Person.sredniaWieku(lista));
        System.out.println();
        System.out.println(Person.iloscLiterWWyrazie(lista));

        Person p5 = new Person("Marek", "Kamiński", LocalDate.of(1988, 7, 30), "Inżynier");
        Person p6 = new Person("Marek", "Kamiński", LocalDate.of(1988, 7, 30), "Inżynier");

        Set<Person> people = new HashSet<>();
        people.add(p5);
        people.add(p6);
        System.out.println(people);
        System.out.println(people.size());
        p5.setFirstName("Andrzej");
        System.out.println(people.contains(p5));
        System.out.println(people);

        Produkt produkt1 = new Produkt("Chleb", 101);
        Produkt produkt2 = new Produkt("Mleko", 102);
        Produkt produkt3 = new Produkt("Masło", 105);
        Produkt produkt4 = new Produkt("Ser", 104);
        Produkt produkt5 = new Produkt("Jajka", 105);

        List<Produkt> produkty = new ArrayList<>();

        produkty.add(produkt1);
        produkty.add(produkt2);
        produkty.add(produkt3);
        produkty.add(produkt4);
        produkty.add(produkt5);

        Produkt produkt21 = new Produkt("Mleko", 102, 55);
        Produkt produkt31 = new Produkt("Masło", 105, 95);
        Produkt produkt41 = new Produkt("Ser", 104, 85);
        Produkt produkt51 = new Produkt("Jajka", 105, 99);

        List<Produkt> produkty1 = new ArrayList<>();
        produkty1.add(produkt21);
        produkty1.add(produkt31);
        produkty1.add(produkt41);
        produkty1.add(produkt51);

        System.out.println();
        System.out.println("Zadanie nr4:");
        System.out.println(mapaProduktow(produkty, 106));
        System.out.println();

        System.out.println("Zadanie nr5");
        System.out.println(najdrozszyProdukt(produkty1));
        System.out.println();

        Produkt p10 = new Produkt("Jabłka", 10.5);
        Produkt p20 = new Produkt("Banany", 7.0);
        Produkt p30 = new Produkt("Pomarańcze", 12.3);
        Produkt p40 = new Produkt("Mleko", 5.0);
        Produkt p50 = new Produkt("Chleb", 8.0);
        Produkt p60 = new Produkt("Masło", 3.5);

        Map<String, Integer> sklep1 = new HashMap<>();
        sklep1.put("Jabłka", 10);
        sklep1.put("Banany", 15);
        sklep1.put("Pomarańcze", 3);

        Map<String, Integer> sklep2 = new HashMap<>();
        sklep2.put("Jabłka", 10);
        sklep2.put("Banany", 15);
        sklep2.put("Mleko", 5);
        sklep2.put("Pomarańcze", 3);

        System.out.println("Zadanie nr6");
        System.out.println(mapaProdkutow(sklep1, sklep2));
        System.out.println();

        Person anna = new Person("Anna", "Warszawa");
        Person jan = new Person("Jan", "Kraków");
        Person piotr = new Person("Piotr", "Warszawa");

        List<Person> listaLudzi = new ArrayList<>();
        listaLudzi.add(jan);
        listaLudzi.add(anna);
        listaLudzi.add(piotr);

        System.out.println(zmianaKluczaNaWartos(listaLudzi));


    }

    // 1. Utwórz Map<String, Integer>, w której kluczem będzie imię, a wartością wiek.
    // Dodaj 5 osób, wypisz całą mapę, a następnie znajdź wiek konkretnej osoby po imieniu.
    public static void czlowiekIMapa(List<Person> lista, int szukanyWiek) {
        Map<String, Integer> mapa = new HashMap<>();
        LocalDate dzisiaj = LocalDate.now();
        for (Person czlowiek : lista) {
            int wiekOsoby = Period.between(czlowiek.getBirtdate(), dzisiaj).getYears();
            mapa.put(czlowiek.getFirstName(), wiekOsoby);
        }
        System.out.println("Mapa = " + mapa);
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            if (entry.getValue() == szukanyWiek) {
                System.out.println("Osoba o szukanym wieku = " + szukanyWiek + " : " + entry.getKey());
            }
        }
    }

    // 2. Napisz program, który zliczy ile razy każde słowo występuje w zdaniu.
    // Wynik zapisz w Map<String, Integer>, gdzie kluczem jest słowo, a wartością liczba jego wystąpień.
    public static Map<String, Integer> mapaWystapienSlow(String zdanie) {
        Map<String, Integer> mapa = new HashMap<>();
        String[] slowa = zdanie.split(" ");
        for (String slowo : slowa) {
            if (mapa.containsKey(slowo)) {
                mapa.put(slowo, mapa.get(slowo) + 1);
            } else {
                mapa.put(slowo, 1);
            }
        }
        return mapa;
    }

    // 3. Masz listę imion uczniów. Pogrupuj je według pierwszej litery.
    // Użyj Map<Character, List<String>>, gdzie np. pod kluczem 'A' będą wszystkie imiona na A.
    public static Map<Character, List<String>> listaUczniowNaPodanaLitere(String[] tablicaUczniow) {
        Map<Character, List<String>> mapa = new HashMap<>();
        for (String uczen : tablicaUczniow) {
            char pierwszaLitera = uczen.charAt(0);
            if (!mapa.containsKey(pierwszaLitera)) {
                mapa.put(pierwszaLitera, new ArrayList<>());
            }
            mapa.get(pierwszaLitera).add(uczen);
        }
        return mapa;
    }

    // 4. Utwórz Map<Integer, String>, gdzie kluczem będzie numer produktu, a wartością jego nazwa.
    // Sprawdź, czy produkt o podanym numerze istnieje, a jeśli nie, dodaj go do mapy.
    public static Map<Integer, String> mapaProduktow(List<Produkt> lista, int szukanyNumer) {
        Map<Integer, String> mapa = new HashMap<>();
        for (Produkt towar : lista) {
            mapa.put(towar.getNumer(), towar.getNazwa());
        }
        if (mapa.containsKey(szukanyNumer)) {
            mapa.get(szukanyNumer);
        } else {
            mapa.put(szukanyNumer, "Nowy towar");
        }
        return mapa;
    }

    // 5. Napisz program, który dla podanej mapy z produktami i cenami
    // znajdzie najdroższy produkt oraz wypisze jego nazwę i cenę.
    public static Produkt najdrozszyProdukt(List<Produkt> lista) {
        Produkt najdrozszy = lista.get(0);
        for (Produkt towar : lista) {
            if (towar.getCena() > najdrozszy.getCena()) {
                najdrozszy = towar;
            }
        }
        return najdrozszy;
    }

    // 6. Utwórz dwie mapy Map<String, Integer> reprezentujące stany magazynowe w dwóch sklepach.
    // Połącz je w jedną mapę tak, aby dla tych samych produktów sumowały się ilości.
    public static Map<String, Integer> mapaProdkutow(Map<String, Integer> mapa1, Map<String, Integer> mapa2) {
        Map<String, Integer> nowaMapa = new HashMap<>(mapa1);
        for (Map.Entry<String, Integer> entry2 : mapa2.entrySet()) {
            nowaMapa.merge(entry2.getKey(), entry2.getValue(), Integer::sum);
        }
        return nowaMapa;
    }

    // 7. Napisz program, który odwróci mapę Map<String, String>,
    // czyli z mapy imię -> miasto utworzy mapę miasto -> imię.
    // Zastanów się, co zrobić, jeśli kilka osób mieszka w tym samym mieście.
    public static Map<String, List<String>> zmianaKluczaNaWartos(List<Person> lista) {
        Map<String, List<String>> zamienionaMapa = new HashMap<>();

        for (Person osoba : lista) {
            String name = osoba.getFirstName();
            String city = osoba.getMiasto();

            zamienionaMapa.putIfAbsent(city, new ArrayList<>());
            zamienionaMapa.get(city).add(name);
        }
        return zamienionaMapa;
    }

    // 8. Utwórz Map<String, List<Integer>>, gdzie kluczem będzie nazwa studenta,
    // a wartością lista jego ocen. Oblicz średnią ocen dla każdego studenta.
    public static Map<String, Double> sredniaOcenaStudentow(Map<String, List<Integer>> mapa) {
        Map<String, Double> nowaMapa = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : mapa.entrySet()) {
            String student = entry.getKey();
            List<Integer> oceny = entry.getValue();
            double suma = 0;
            for (int ocena : oceny) {
                suma += ocena;
            }

            double srednia = suma / oceny.size();
            nowaMapa.put(student, srednia);
        }
        return nowaMapa;
    }

    // 9. Napisz program, który porówna dwie mapy i wypisze:
    // - klucze występujące tylko w pierwszej mapie,
    // - klucze występujące tylko w drugiej mapie,
    // - klucze wspólne dla obu map.
    public static void kluczeZDwochMap(Map<String,String> mapa1, Map<String,String> mapa2) {
        Set<String> klucze1 = mapa1.keySet();
        Set<String> klucze2 = mapa2.keySet();

        Set<String> zPierwszejMapy = new HashSet<>(klucze1);
        zPierwszejMapy.removeAll(klucze2);

        Set<String> zDrugiejMapy = new HashSet<>(klucze2);
        zDrugiejMapy.removeAll(klucze1);

        Set<String> wspolne = new HashSet<>(klucze1);
        wspolne.retainAll(klucze2);

        System.out.println("Mapa1: " + zPierwszejMapy);
        System.out.println("Mapa2: " + zDrugiejMapy);
        System.out.println("Wspólne: " + wspolne);
    }


}
//Napisz funkcje ktora obliczy sarednia wieku z osob podanych w parametrze
///Person(firstname,lastname,birtdate,job)

//Napisz funkcje ktora obliczy ile jakich liter zostalo uzyte w imionach osob
//a-5,j-2,o-3...

// 1. Utwórz Map<String, Integer>, w której kluczem będzie imię, a wartością wiek.
// Dodaj 5 osób, wypisz całą mapę, a następnie znajdź wiek konkretnej osoby po imieniu.

// 2. Napisz program, który zliczy ile razy każde słowo występuje w zdaniu.
// Wynik zapisz w Map<String, Integer>, gdzie kluczem jest słowo, a wartością liczba jego wystąpień.

// 3. Masz listę imion uczniów. Pogrupuj je według pierwszej litery.
// Użyj Map<Character, List<String>>, gdzie np. pod kluczem 'A' będą wszystkie imiona na A.

// 4. Utwórz Map<Integer, String>, gdzie kluczem będzie numer produktu, a wartością jego nazwa.
// Sprawdź, czy produkt o podanym numerze istnieje, a jeśli nie, dodaj go do mapy.

// 5. Napisz program, który dla podanej mapy z produktami i cenami
// znajdzie najdroższy produkt oraz wypisze jego nazwę i cenę.

// 6. Utwórz dwie mapy Map<String, Integer> reprezentujące stany magazynowe w dwóch sklepach.
// Połącz je w jedną mapę tak, aby dla tych samych produktów sumowały się ilości.

// 7. Napisz program, który odwróci mapę Map<String, String>,
// czyli z mapy imię -> miasto utworzy mapę miasto -> imię.
// Zastanów się, co zrobić, jeśli kilka osób mieszka w tym samym mieście.

// 8. Utwórz Map<String, List<Integer>>, gdzie kluczem będzie nazwa studenta,
// a wartością lista jego ocen. Oblicz średnią ocen dla każdego studenta.

// 9. Napisz program, który porówna dwie mapy i wypisze:
// - klucze występujące tylko w pierwszej mapie,
// - klucze występujące tylko w drugiej mapie,
// - klucze wspólne dla obu map.

// 10. Utwórz książkę telefoniczną jako Map<String, String>,
// gdzie kluczem jest nazwisko, a wartością numer telefonu.
// Dodaj kilka wpisów, usuń jeden, zaktualizuj jeden numer i wypisz wszystkie kontakty posortowane po nazwisku.