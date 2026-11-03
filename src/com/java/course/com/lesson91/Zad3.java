package com.java.course.com.lesson91;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Zad3 {
    public static void main(String[] args) {
        Person p1 = new Person("Adam","Nowak",35);
        Person p2 = new Person("Adam","Nowak",35);
        Person p3 = new Person("Ala","Kowalska",22);

        Set<Person> people = new HashSet<>();
        //people.add(p1);
        //people.add(p2);
        //people.add(p3);
        System.out.println(people);
        System.out.println();

        System.out.println(people.contains(p1));
        p1.setFirstName("Jakub");
        System.out.println(people.contains(p1));
    }
}
class Person{
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
