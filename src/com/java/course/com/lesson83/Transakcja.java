package com.java.course.com.lesson83;

public class Transakcja {
    private String typ;
    private double kwota;

    public Transakcja(String typ, double kwota) {
        this.typ = typ;
        this.kwota = kwota;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public double getKwota() {
        return kwota;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    @Override
    public String toString() {
        return "Transakcja{" +
                "typ='" + typ + '\'' +
                ", kwota=" + kwota +
                '}';
    }
}
