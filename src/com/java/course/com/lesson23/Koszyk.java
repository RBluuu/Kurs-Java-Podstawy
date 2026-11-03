package com.java.course.com.lesson23;

import java.util.List;

public class Koszyk {
    private List<Produkt> produkty;

    public Koszyk(List<Produkt> produkty) {
        this.produkty = produkty;
    }

    //napisz funkcje ktora obliczy sume do zaplaty koszyka
    public double cenaKoszyka() {
        double cenaKoszyka = 0;
        for (Produkt produkt : this.getProdukty()) {
            cenaKoszyka += produkt.getCena() * produkt.getIlosc();
        }
        return cenaKoszyka;
    }

    public double cenaPoDodaniuPlatnosci(String rodzajPlatnosci) {
        double cena = cenaKoszyka();
        if (rodzajPlatnosci.equals("karta")) {
            return cena + cena * 0.2;
        } else if (rodzajPlatnosci.equals("przelew")) {
            return cena + cena * 0.3;
        } else if (rodzajPlatnosci.equals("pobranie")) {
            return cena + 13;
        }
        throw new IllegalArgumentException("Rodzaj platnosci nieznany");
    }

    public double cenaPoDodaniuPlatnosciV2(RodzajPlatnosci rodzajPlatnosci) {
        double cena = cenaKoszyka();
        return cena + rodzajPlatnosci.dopłata(cena);
    }

    public List<Produkt> listaPoUsunieciu(String nazwaProdukty) {
        for (int i = 0; i < produkty.size(); i++) {
            Produkt produkt = produkty.get(i);
            if (produkt.getNazwa().equals(nazwaProdukty)) {
                produkty.remove(produkt);
            }
        }
        return produkty;
    }


    public List<Produkt> getProdukty() {
        return produkty;
    }

    public void setProdukty(List<Produkt> produkty) {
        this.produkty = produkty;
    }


}
