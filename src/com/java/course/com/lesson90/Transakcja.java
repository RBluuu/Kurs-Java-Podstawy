package com.java.course.com.lesson90;

import java.util.*;
import java.util.stream.Collectors;

public class Transakcja {
    //Zadanie 1: Sklep internetowy — najlepiej sprzedający się produkt
    //
    //Masz listę obiektów Transakcja (POJO z getProdukt(), getIloscSztuk() — int, getCena() — double za sztukę).
    //
    //Napisz Stream, który:
    //
    //Policzy łączny przychód (ilość × cena) ze wszystkich transakcji, wykorzystując reduce (nie Collectors.summingDouble) —
    // spróbuj stream.reduce(...) z odpowiednią wartością początkową i funkcją łączącą

    //Osobno: zwróci Map<String, Integer> — nazwa produktu -> suma sprzedanych sztuk tego produktu
    // (jeśli ten sam produkt występuje w wielu transakcjach, sumujesz ilości)
    private String produkt;
    private int iloscSztuk;
    private double cena;

    public Transakcja(String produkt, int iloscSztuk, double cena) {
        this.produkt = produkt;
        this.iloscSztuk = iloscSztuk;
        this.cena = cena;
    }

    //Osobno: zwróci Map<String, Integer> — nazwa produktu -> suma sprzedanych sztuk tego produktu
    // (jeśli ten sam produkt występuje w wielu transakcjach, sumujesz ilości)

    public static Map<String,Integer> iloscSprzedanychSztukKazdegoProduktu(List<Transakcja> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Transakcja::getProdukt,
                        Collectors.summingInt(Transakcja::getIloscSztuk)
                ));
    }

    public static double najlepszyProdukt(List<Transakcja> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(transakcja -> transakcja.getIloscSztuk() * transakcja.getCena())
                .reduce(0.0, Double::sum);
    }

    public String getProdukt() {
        return produkt;
    }

    public void setProdukt(String produkt) {
        this.produkt = produkt;
    }

    public int getIloscSztuk() {
        return iloscSztuk;
    }

    public void setIloscSztuk(int iloscSztuk) {
        this.iloscSztuk = iloscSztuk;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transakcja that = (Transakcja) o;
        return iloscSztuk == that.iloscSztuk && Double.compare(cena, that.cena) == 0 && Objects.equals(produkt, that.produkt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produkt, iloscSztuk, cena);
    }

    @Override
    public String toString() {
        return "SklepInternetowy{" +
                "produkt='" + produkt + '\'' +
                ", iloscSztuk=" + iloscSztuk +
                ", cena=" + cena +
                '}';
    }
}
