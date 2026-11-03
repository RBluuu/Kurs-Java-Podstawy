package com.java.course.com.lesson90;

import java.util.*;
import java.util.stream.Collectors;

public class Zamowienie {
    //Zadanie 1: Analiza zamówień w sklepie
    //
    //Masz listę obiektów Zamowienie (POJO z getId(), getKlient(), getKwota(), getStatus() — status to np. "ZREALIZOWANE", "ANULOWANE", "W_TRAKCIE").
    //
    //Napisz jednym pipeline'em Stream:
    //
    //Policz łączną kwotę wszystkich zamówień o statusie "ZREALIZOWANE"
    //Wynik jako BigDecimal lub double (Twój wybór)
    //
    //Dodatkowo: pogrupuj zamówienia po statusie i policz ile ich jest w każdej grupie (Map<String, Long>).
    private int id;
    private String klient;
    private double kwota;
    private String status;

    public Zamowienie(int id, String klient, double kwota, String status) {
        this.id = id;
        this.klient = klient;
        this.kwota = kwota;
        this.status = status;
    }

    public static double lacznaKwotaZamowien(List<Zamowienie> lista, String rodzajStatus){
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(zamowienie -> zamowienie.getStatus().equals(rodzajStatus))
                .collect(Collectors.summingDouble(Zamowienie::getKwota));
    }

    ////Dodatkowo: pogrupuj zamówienia po statusie i policz ile ich jest w każdej grupie (Map<String, Long>).
    public static Map<String,Long> grupowanieZamowien(List<Zamowienie> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Zamowienie::getStatus,
                        Collectors.counting()
                ));
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKlient() {
        return klient;
    }

    public void setKlient(String klient) {
        this.klient = klient;
    }

    public double getKwota() {
        return kwota;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zamowienie that = (Zamowienie) o;
        return id == that.id && Double.compare(kwota, that.kwota) == 0 && Objects.equals(klient, that.klient) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, klient, kwota, status);
    }

    @Override
    public String toString() {
        return "Zamowienie{" +
                "id=" + id +
                ", klient='" + klient + '\'' +
                ", kwota=" + kwota +
                ", status='" + status + '\'' +
                '}';
    }
}
