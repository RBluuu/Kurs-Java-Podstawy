package com.java.course.com.lesson83;

import java.util.List;

public class Zamowienie {
    private String imieKlienta;
    private List<Produkt> listaProduktow;

    public Zamowienie(String imieKlienta, List<Produkt> listaProduktow) {
        this.imieKlienta = imieKlienta;
        this.listaProduktow = listaProduktow;
    }

    public String getImieKlienta() {
        return imieKlienta;
    }

    public void setImieKlienta(String imieKlienta) {
        this.imieKlienta = imieKlienta;
    }

    public List<Produkt> getListaProduktow() {
        return listaProduktow;
    }

    public void setListaProduktow(List<Produkt> listaProduktow) {
        this.listaProduktow = listaProduktow;
    }

    @Override
    public String toString() {
        return "Zamowienie{" +
                "imieKlienta='" + imieKlienta + '\'' +
                ", listaProduktow=" + listaProduktow +
                '}';
    }

}
