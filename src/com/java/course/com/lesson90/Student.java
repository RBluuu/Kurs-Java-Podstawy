package com.java.course.com.lesson90;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    //Zadanie 3: Studenci i oceny
    //
    //Masz listę obiektów Student (POJO z getImie(), getOceny() — gdzie getOceny() zwraca List<Integer>).
    //
    //Napisz Stream, który:
    //
    //Odfiltruje studentów, których średnia ocen jest >= 4.5
    //Zwróci Map<String, Double> — imię studenta -> jego średnia (tylko dla tych, którzy przeszli próg)
    //Pamiętaj o null-safety (jak zwykle stosujesz Optional/filter(Objects::nonNull))
    private String imie;
    private List<Integer> oceny;

    public Student(String imie, List<Integer> oceny) {
        this.imie = imie;
        this.oceny = oceny;
    }

    public static Map<String, Double> studenciePowyzej4I5 (List<Student> lista, double srednia) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(student -> sredniaStudenta(student) >= srednia)
                .collect(Collectors.groupingBy(
                        Student::getImie,
                        Collectors.averagingDouble(Student::sredniaStudenta)
                ));
    }

    private static double sredniaStudenta(Student student) {
        double suma = 0;
        for (int i = 0; i < student.getOceny().size(); i++) {
            suma += student.getOceny().get(i); // ???
        }
        return suma / student.getOceny().size();
    }
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public List<Integer> getOceny() {
        return oceny;
    }

    public void setOceny(List<Integer> oceny) {
        this.oceny = oceny;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(imie, student.imie) && Objects.equals(oceny, student.oceny);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, oceny);
    }

    @Override
    public String toString() {
        return "Student{" +
                "imie='" + imie + '\'' +
                ", oceny=" + oceny +
                '}';
    }
}
