package com.java.course.com.przykladyNowe;

import java.util.*;
import java.util.stream.Collectors;

public class Main7 {
    public static void main(String[] args) {

        /*
        Napisz metodę, która:

        przyjmuje listę pracowników,
        wybiera tylko tych, którzy mają więcej niż 30 lat,
        sortuje ich malejąco po pensji,
        zwraca listę samych imion.
         */
        Employee emp1 = new Employee("Jan Kowalski", 28, 5500.0);
        Employee emp2 = new Employee("Anna Nowak", 35, 7200.5);
        Employee emp3 = new Employee("Piotr Wiśniewski", 41, 8100.0);
        Employee emp4 = new Employee("Katarzyna Zielińska", 24, 4800.75);
        Employee emp5 = new Employee("Marek Lewandowski", 30, 6700.0);

        List<Employee> personList = new ArrayList<>();
        personList.add(emp1);
        personList.add(emp2);
        personList.add(emp3);
        personList.add(emp4);
        personList.add(emp5);
        System.out.println(personList);
        System.out.println();
        System.out.println("Zadanie nr1");
        System.out.println(specialList(personList));
        System.out.println();

        Order order1 = new Order("Elektronika", 2499.99);
        Order order2 = new Order("Książki", 89.50);
        Order order3 = new Order("Odzież", 349.90);
        Order order4 = new Order("Książki", 129.99);
        Order order5 = new Order("Sport", 799.00);

        /*
        Napisz kod wykorzystujący Stream API, który:

        pogrupuje zamówienia po kategorii,
        policzy sumę wartości zamówień dla każdej kategorii.
         */

        /*
        Napisz kod wykorzystujący Stream API, który:

        podzieli tekst na słowa,
        policzy ile razy występuje każde słowo,
        zwróci wynik w postaci Map<String, Long>.
         */

        String text = "java stream java lambda stream api java";
        System.out.println("Zadnie 2");
        System.out.println(divideString(text));

        /*
        Napisz rozwiązanie przy użyciu Stream API, które:

        znajdzie wszystkie duplikaty,
        zwróci je jako Set<Integer>
         */

        List<Integer> numbers = List.of(1,2,3,4,2,5,6,3,7,1);
        System.out.println("Zadanie nr3");
        System.out.println(numberOfList(numbers));
        System.out.println();

        List<Order> orderList = new ArrayList<>(List.of(order1,order2,order3,order4,order5));
        System.out.println("Zadanie 4");
        System.out.println(gupingByKategorii(orderList));


    }

    public static List<String> specialList(List<Employee> employees) {
        return Optional.ofNullable(employees)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public static Map<String, Long> divideString(String text) {
        return Arrays.stream(
                        Optional.ofNullable(text)
                                .orElse("")
                                .split("\\s+")
                )
                .filter(word -> !word.isBlank())
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()

                ));
    }

    public static Set<Integer> numberOfList(List<Integer> list) {
        Set<Integer> setList = new HashSet<>();
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(number -> !setList.add(number))
                .collect(Collectors.toSet());
    }

    //pogrupuje zamówienia po kategorii,
    //policzy sumę wartości zamówień dla każdej kategorii.

    public static Map<String, Double> gupingByKategorii(List<Order> orderList) {
        return Optional.ofNullable(orderList)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Order::getCategory,
                        Collectors.summingDouble(Order::getAmount)
                ));
    }

}
