package com.java.course.com.lesson90;

import java.util.*;
import java.util.stream.Collectors;

public class Zamowienie2 {
    //Zadanie 2: Zamówienia klientów — zagnieżdżone listy
    //
    //Masz listę obiektów Klient (POJO z getImie(), getZamowienia() — gdzie getZamowienia() zwraca List<String>,
    // czyli nazwy zamówionych produktów).
    //
    //Napisz Stream, który:
    //
    //Wykorzysta flatMap, żeby zebrać wszystkie zamówione produkty od wszystkich klientów do jednej płaskiej listy List<String>,
    // bez duplikatów
    //Dodatkowo: znajdzie klienta z największą liczbą zamówień (po rozmiarze jego listy getZamowienia())
    private String imie;
    private List<String> listaZamowien;

    public Zamowienie2(String imie, List<String> listaZamowien) {
        this.imie = imie;
        this.listaZamowien = listaZamowien;
    }

    public static List<String> jednaLista(List<Zamowienie2> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMap(klient -> klient.getListaZamowien().stream())
                .distinct()
                .collect(Collectors.toList());

    }


    public static String klientZNajwiekszaLista(List<Zamowienie2> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(klient -> klient.getListaZamowien().size()))
                .map(Zamowienie2::getImie)
                .findFirst()
                .orElse("null");
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public List<String> getListaZamowien() {
        return listaZamowien;
    }

    public void setListaZamowien(List<String> listaZamowien) {
        this.listaZamowien = listaZamowien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zamowienie2 that = (Zamowienie2) o;
        return Objects.equals(imie, that.imie) && Objects.equals(listaZamowien, that.listaZamowien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, listaZamowien);
    }

    @Override
    public String toString() {
        return "Zamowienie2{" +
                "imie='" + imie + '\'' +
                ", listaZamowien=" + listaZamowien +
                '}';
    }
}
