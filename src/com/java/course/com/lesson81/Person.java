package com.java.course.com.lesson81;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birtdate;
    private String job;

    private int wiek;

    private String miasto;


    public Person(String firstName, String lastName, LocalDate birtdate, String job) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birtdate = birtdate;
        this.job = job;
    }

    public Person(String firstName, String miasto) {
        this.firstName = firstName;
        this.miasto = miasto;
    }

    public Person(String firstName, String lastName, LocalDate birtdate, String job, int wiek, String miasto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birtdate = birtdate;
        this.job = job;
        this.wiek = wiek;
        this.miasto = miasto;
    }

    public int wiek() {
        LocalDate dzisiaj = LocalDate.now();
        int wiekOsoby = Period.between(this.getBirtdate(), dzisiaj).getYears();
        return wiekOsoby;
    }

    //Napisz funkcje ktora obliczy sarednia wieku z osob podanych w parametrze
    public static double sredniaWieku(List<Person> person) {
        double srednia = 0;
        LocalDate dzisiaj = LocalDate.now();
        double   suma = 0;
        for (Person osoba : person) {
            int wiekOsoby = Period.between(osoba.birtdate,dzisiaj).getYears();
            suma += wiekOsoby;
        }
        srednia = suma / person.size();
        return srednia;

    }

    public static HashMap<Character,Integer> iloscLiterWWyrazie(List<Person> lista) {
        HashMap<Character,Integer> mapa = new HashMap<>();
        for (Person osoba : lista) {
            String imie = osoba.getFirstName().toLowerCase();
            for (char litera : imie.toCharArray()) {
                mapa.put(litera, mapa.getOrDefault(litera,0)+1);
            }
        }
        return mapa;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirtdate() {
        return birtdate;
    }

    public void setBirtdate(LocalDate birtdate) {
        this.birtdate = birtdate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birtdate=" + birtdate +
                ", job='" + job + '\'' +
                ", wiek=" + wiek +
                ", miasto='" + miasto + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(birtdate, person.birtdate) && Objects.equals(job, person.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birtdate, job);
    }
}
