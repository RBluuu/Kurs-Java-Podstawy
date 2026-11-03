package com.java.course.com.lesson88;

public class Uzytkownik {
    /*
    Napisz klasę Uzytkownik, która:

    ma pole instancyjne nazwa (String)
    ma statyczne pole liczbaUzytkownikow, które zlicza, ile obiektów Uzytkownik zostało dotąd utworzonych
    w konstruktorze zwiększa ten licznik o 1
    ma statyczną metodę getLiczbaUzytkownikow(), zwracającą aktualną wartość licznika
    ma instancyjną metodę przedstawSie(), zwracającą np. "Cześć, jestem Anna"
    java
     */
    private String nazwa;
    private static int licznikUzytkownikow = 0;

    public Uzytkownik(String nazwa) {
        if (nazwa == null) {
            System.out.println("FALSE");
        }
        this.nazwa = nazwa;
        licznikUzytkownikow++;
    }

    public String przedstawSie() {
        return ("Czesc, jestem " + this.nazwa);
    }

    public static int getLicznikUzytkownikowDoZadania() {
        return licznikUzytkownikow;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Uzytkownik{" +
                "nazwa='" + nazwa + '\'' +
                ", licznikUzytkownikow=" + licznikUzytkownikow +
                '}';
    }
}
