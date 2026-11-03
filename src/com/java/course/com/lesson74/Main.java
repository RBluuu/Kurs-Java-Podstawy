package com.java.course.com.lesson74;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String test = "test@email.com";
        Optional<String> optional = Optional.ofNullable(test);
        if (optional.isPresent()) {
            System.out.println("istnieje + " + optional.get());
        } else {
            System.out.println("nie istnieje");
        }

        String email = optional.orElse(test);
        System.out.println(email);

        /*
        Poprawic test
        Obejrzec filmik
        Projekt wycieczka
         */
        //1. Napisz metodę, która przyjmuje tablicę liczb całkowitych i zwraca sumę wszystkich elementów.

        //2. Napisz metodę, która znajduje największy element w tablicy.

        //3. Napisz metodę, która znajduje najmniejszy element w tablicy.

        //4. Napisz metodę, która oblicza średnią wartość elementów w tablicy.

        //5. Napisz metodę, która liczy ile elementów w tablicy jest większych od podanej liczby x.

        //6. Napisz metodę, która zlicza ile w tablicy jest liczb parzystych.

        //7. Napisz metodę, która tworzy nową tablicę zawierającą tylko liczby parzyste z oryginalnej tablicy.

        //8. Napisz metodę, która odwraca kolejność elementów w tablicy.

        //9. Napisz metodę, która sprawdza czy tablica zawiera podaną liczbę.

        //10. Napisz metodę, która zlicza ile razy dana liczba występuje w tablicy.

        //11. Napisz metodę, która znajduje indeks największego elementu w tablicy.

        //12. Napisz metodę, która tworzy nową tablicę zawierającą elementy większe od średniej wartości tablicy.

        //13. Napisz metodę, która zamienia wszystkie liczby ujemne w tablicy na 0.

        //14. Napisz metodę, która przesuwa wszystkie elementy tablicy o jedno miejsce w prawo (ostatni element trafia na początek).

        //15. Napisz metodę, która przesuwa wszystkie elementy tablicy o jedno miejsce w lewo (pierwszy element trafia na koniec).

        //16. Napisz metodę, która sprawdza czy tablica jest posortowana rosnąco.

        //17. Napisz metodę, która znajduje drugi największy element w tablicy.

        //18. Napisz metodę, która scala dwie tablice w jedną większą tablicę.

        //19. Napisz metodę, która usuwa wszystkie wystąpienia danej liczby z tablicy (zwraca nową tablicę).

        //20. Napisz metodę, która sprawdza czy dwie tablice są identyczne (mają te same elementy w tej samej kolejności).

        //21. Napisz metodę, która znajduje element najbliższy średniej wartości tablicy.

        //22. Napisz metodę, która znajduje najdłuższą rosnącą sekwencję kolejnych elementów w tablicy.

        //23. Napisz metodę, która sprawdza czy tablica zawiera duplikaty.

        //24. Napisz metodę, która zwraca tablicę zawierającą tylko unikalne elementy z oryginalnej tablicy.

        //25. Napisz metodę, która dla każdej liczby w tablicy zwraca jej kwadrat w nowej tablicy.

        //26. Napisz metodę, która zamienia miejscami pierwszy i ostatni element tablicy.

        //27. Napisz metodę, która sprawdza czy tablica jest palindromem (czyta się tak samo od przodu i od tyłu).

        //28. Napisz metodę, która znajduje różnicę między największym a najmniejszym elementem tablicy.

        //29. Napisz metodę, która zwraca indeks pierwszego elementu większego od podanej liczby.

        //30. Napisz metodę, która sortuje tablicę rosnąco bez użycia wbudowanych metod sortowania.


    }
}
