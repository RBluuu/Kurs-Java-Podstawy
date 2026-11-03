package com.java.course.com.lesson83;

public class PracownikIT {
    private String name;
    private String dzial;
    private double pensja;

    public PracownikIT(String name, String dzial, double pensja) {
        this.name = name;
        this.dzial = dzial;
        this.pensja = pensja;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "PracownikIT{" +
                "name='" + name + '\'' +
                ", dzial='" + dzial + '\'' +
                ", pensja=" + pensja +
                '}';
    }
}
