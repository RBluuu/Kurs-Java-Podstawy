package com.java.course.com.lesson84;

public class Person {
    private String name;
    private int wiek;

    public Person(String name, int wiek) {
        this.name = name;
        this.wiek = wiek;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}
