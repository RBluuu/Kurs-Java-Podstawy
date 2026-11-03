package com.java.course.com.lesson86;

public class Pracownik {
    //Masz listę obiektów Pracownik (pola: imie, wiek, pensja). Napisz kod sortujący tę listę:
    //
    //Najpierw po pensja malejąco.
    //Przy remisie — po imie alfabetycznie.
    private String imie;
    private int wiek;
    private double pensja;

    public Pracownik(String imie, int wiek, double pensja) {
        this.imie = imie;
        this.wiek = wiek;
        this.pensja = pensja;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
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
                ", wiek=" + wiek +
                ", pensja=" + pensja +
                '}';
    }
}
