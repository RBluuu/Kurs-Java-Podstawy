package com.java.course.com.lesson89;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Contribution {
    private BigDecimal kwota;
    private LocalDate data;
    private String tytlPlaty;

    public Contribution(BigDecimal kwota, LocalDate data, String tytlPlaty) {
        this.kwota = kwota;
        this.data = data;
        this.tytlPlaty = tytlPlaty;
    }

    public BigDecimal getKwota() {
        return kwota;
    }

    public void setKwota(BigDecimal kwota) {
        this.kwota = kwota;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTytlPlaty() {
        return tytlPlaty;
    }

    public void setTytlPlaty(String tytlPlaty) {
        this.tytlPlaty = tytlPlaty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contribution that = (Contribution) o;
        return Objects.equals(kwota, that.kwota) && Objects.equals(data, that.data) && Objects.equals(tytlPlaty, that.tytlPlaty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kwota, data, tytlPlaty);
    }

    @Override
    public String toString() {
        return "Contribution{" +
                "kwota=" + kwota +
                ", data=" + data +
                ", tytlPlaty='" + tytlPlaty + '\'' +
                '}';
    }
}
