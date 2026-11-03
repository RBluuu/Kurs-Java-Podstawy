package com.java.course.com.lesson88;

public class Zamowienie {

    private String klient;
    private Double kwota;

    public Zamowienie(String klient, Double kwota) {
        this.klient = klient;
        this.kwota = kwota;
    }

    public String getKlient() {
        return klient;
    }

    public void setKlient(String klient) {
        this.klient = klient;
    }

    public Double getKwota() {
        return kwota;
    }

    public void setKwota(Double kwota) {
        this.kwota = kwota;
    }

    @Override
    public String toString() {
        return "Zamowienie{" +
                "klient='" + klient + '\'' +
                ", kwota=" + kwota +
                '}';
    }
}
