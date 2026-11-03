package com.java.course.com.lesson77;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String lastName;

   private List<Product> listaProcuktow = new ArrayList<>();

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public void addProduckt(Product product) {
        this.getListaProcuktow().add(product);
        product.setPerson(this);
    }

    public double suma() {
        double suma = 0;
        for (int i = 0; i < this.getListaProcuktow().size(); i++) {
            suma += this.getListaProcuktow().get(i).getPrice() ;
        }
        return suma;
    }



    public List<Product> getListaProcuktow() {
        return listaProcuktow;
    }

    public void setListaProcuktow(List<Product> listaProcuktow) {
        this.listaProcuktow = listaProcuktow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
