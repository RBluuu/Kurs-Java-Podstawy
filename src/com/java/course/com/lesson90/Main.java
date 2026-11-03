package com.java.course.com.lesson90;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        //List<Integer> list2 = new Arrays.asList(List.of(1,2,3,4,5));
        List<Integer> list3 = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        Person radek = new Person("Radek", "Nowak", 38);
        Person radek2 = new Person("Radek", "Nowak", 38);
        Person marek = new Person("Marek", "Kowalski", 33);

        HashSet hashSet = new HashSet<>();
        hashSet.add(radek);
        hashSet.add(radek2);
        hashSet.add(marek);

        radek.setFirstName("michal");


        System.out.println(hashSet);
        System.out.println(hashSet.contains(radek));
        System.out.println();
        Integer n1 = 1200;
        Integer n2 = 1200;
        System.out.println(n1 == n2); // false
        System.out.println(n1.equals(n2)); // true
        String hello1 = "hello";
        String hello2 = "hello";
        String hello3 = new String("hello");
        System.out.println(hello1 == hello2);
        System.out.println(hello1.equals(hello2));
        System.out.println(hello1 == hello3);
        System.out.println(hello1.equals(hello3));
        System.out.println();


        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 123));
        Integer toRemove = 123;
        list1.remove(toRemove);
        System.out.println(list1);

        List<int[]> listaTablic = new ArrayList<>();
        listaTablic.add(new int[]{1, 2, 3, 6});
        listaTablic.add(new int[]{69, 55, 2, 96, 196, 169});
        System.out.println();
        System.out.println("Lista: " + liczbyBez6I9(listaTablic, 6, 9));
    }
    //60,90,69,96
    //Napisz metode ktora jako argument pobiera liste tablic intow a jako wynik zwraca te liczby ktore nie maja w sobie cyfr 6 i 9

    //Zadanie 1: Analiza zamówień w sklepie
    //
    //Masz listę obiektów Zamowienie (POJO z getId(), getKlient(), getKwota(), getStatus() — status to np.
    // "ZREALIZOWANE", "ANULOWANE", "W_TRAKCIE").
    //
    //Napisz jednym pipeline'em Stream:
    //
    //Policz łączną kwotę wszystkich zamówień o statusie "ZREALIZOWANE"
    //Wynik jako BigDecimal lub double (Twój wybór)
    //
    //Dodatkowo: pogrupuj zamówienia po statusie i policz ile ich jest w każdej grupie (Map<String, Long>).


    //Zadanie 2: Najczęściej występujące słowo
    //
    //Masz List<String> zdania — listę zdań (np. tekst podzielony na linie).
    //
    //Znajdź najczęściej występujące słowo w całym tekście (ignorując wielkość liter, bez znaków interpunkcyjnych). Wykorzystaj:
    //
    //flatMap do rozbicia zdań na słowa
    //Collectors.groupingBy + Collectors.counting()
    //znalezienie maksimum z mapy (np. przez entrySet().stream().max(...))


   //Zadanie 1: Biblioteka — książki i autorzy
    //
    //Masz listę obiektów Ksiazka (POJO z getTytul(), getAutor(), getRokWydania(), getOcena() — ocena jako double, np. 4.2).
    //
    //Napisz Stream, który:
    //
    //Znajdzie tytuł książki z najwyższą oceną (zwróć Optional<String> albo sam tytuł z sensownym fallbackiem)
    //Osobno: zwróci listę tytułów książek wydanych po roku 2015, posortowaną alfabetycznie

    public static String najczesciejWystepujaceSlowo(List<String> lista ) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMap(text -> Arrays.stream(text.split("\\W+")))
                .collect(Collectors.groupingBy(
                        slowo -> slowo.toLowerCase(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }












    public static List<Integer> liczbyBez6I9(List<int[]> listaTablic, int liczbaNR1, int liczbaNR2) {
        List<Integer> nowaLista = new ArrayList<>();
        for (int[] lista : listaTablic) {
            for (int liczba : lista) {
                boolean zakazaCyfra = false;
                int kopia = liczba;
                while (kopia > 0) {
                    int cyfra = kopia % 10;
                    kopia = kopia / 10;
                    if (cyfra == liczbaNR1 || cyfra == liczbaNR2) {
                        zakazaCyfra = true;
                        break;
                    }
                }
                if (!zakazaCyfra) {
                    nowaLista.add(liczba);
                }
            }
        }
        return nowaLista;
    }








}
