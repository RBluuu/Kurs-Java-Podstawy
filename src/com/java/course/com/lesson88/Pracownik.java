package com.java.course.com.lesson88;

public class Pracownik {
    private String imie;
    private String dzial;
    private double pensja;

    public Pracownik(String imie, String dzial, double pensja) {
        this.imie = imie;
        this.dzial = dzial;
        this.pensja = pensja;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getDzial() {
        return dzial;
    }

    public void setDzial(String dzial) {
        this.dzial = dzial;
    }

    public double getPensja() {
        return pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "imie='" + imie + '\'' +
                ", branza='" + dzial + '\'' +
                ", pensja=" + pensja +
                '}';
    }
}
