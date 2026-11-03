package com.java.course.com.lesson90;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Ksiazka {
    //Zadanie 1: Biblioteka — książki i autorzy
    //
    //Masz listę obiektów Ksiazka (POJO z getTytul(), getAutor(), getRokWydania(), getOcena() — ocena jako double, np. 4.2).
    //
    //Napisz Stream, który:
    //
    //Znajdzie tytuł książki z najwyższą oceną (zwróć Optional<String> albo sam tytuł z sensownym fallbackiem)
    //Osobno: zwróci listę tytułów książek wydanych po roku 2015, posortowaną alfabetycznie

    private String tytul;
    private String autor;
    private LocalDate dataWydania;
    private double ocena;

    public Ksiazka(String tytul, String autor, LocalDate dataWydania, double ocena) {
        this.tytul = tytul;
        this.autor = autor;
        this.dataWydania = dataWydania;
        this.ocena = ocena;
    }

    public static List<String> listaKsiazekPoRoku(List<Ksiazka> lista, LocalDate data) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(ksiazka -> ksiazka.getDataWydania().isAfter(data))
                .sorted(Comparator.comparing(Ksiazka::getTytul))
                .map(Ksiazka::getTytul)
                .collect(Collectors.toList());
    }

    public static Optional<String> ksiazkaZNajwyzszaOcena(List<Ksiazka> listaKsiazek) {
        return Optional.ofNullable(listaKsiazek)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingDouble(Ksiazka::getOcena).reversed())
                .map(Ksiazka::getTytul)
                .findFirst();
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataWydania() {
        return dataWydania;
    }

    public void setDataWydania(LocalDate dataWydania) {
        this.dataWydania = dataWydania;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ksiazka ksiazka = (Ksiazka) o;
        return Double.compare(ocena, ksiazka.ocena) == 0 && Objects.equals(tytul, ksiazka.tytul) && Objects.equals(autor, ksiazka.autor) && Objects.equals(dataWydania, ksiazka.dataWydania);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tytul, autor, dataWydania, ocena);
    }

    @Override
    public String toString() {
        return "Ksiazka{" +
                "tytul='" + tytul + '\'' +
                ", autor='" + autor + '\'' +
                ", dataWydania=" + dataWydania +
                ", ocena=" + ocena +
                '}';
    }
}
