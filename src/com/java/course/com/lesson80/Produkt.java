package com.java.course.com.lesson80;

public class Produkt {
    private String nazwa;
    private int numer;
    private int cena;
    private double ilosc;


    public Produkt(String nazwa, int numer) {
        this.nazwa = nazwa;
        this.numer = numer;
    }

    public Produkt(String nazwa, int numer, int cena) {
        this.nazwa = nazwa;
        this.numer = numer;
        this.cena = cena;
    }

    public Produkt(String nazwa, double ilosc) {
        this.nazwa = nazwa;
        this.ilosc = ilosc;
    }

    public double getIlosc() {
        return ilosc;
    }

    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "nazwa='" + nazwa + '\'' +
                ", numer=" + numer +
                ", cena=" + cena +
                ", ilosc=" + ilosc +
                '}';
    }
}
