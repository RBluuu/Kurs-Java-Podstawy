package com.java.course.com.lesson77;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(12);
        lista.add(5);
        lista.add(5);
        lista.add(6);
        lista.add(8);
        //12,5,6,8
        System.out.println("Lista bez nieparzystych = " + listaBezNieparzystych(lista));

        int[] lista1 = {1, 2, 3};
        int[] lista2 = {1, 2, 3, 4, 5};
        List<int[]> listaList = new ArrayList<>();
        listaList.add(lista1);
        listaList.add(lista2);
        System.out.println("Suma liczb z list = " + suma(listaList));


        int suma = 0;
        //suma += new int[]{1,2,3};


        Person janek = new Person("Janek", "Nowak");
        Person marke = new Person("Marek", "Kowalski");

        Product rower = new Product("Romet", 1200);
        Product telefon = new Product("Nokia", 999.99);
        Product moniotor = new Product("HP", 459.99);

        janek.addProduckt(rower);
        janek.addProduckt(telefon);
        janek.addProduckt(moniotor);

        marke.addProduckt(telefon);

        System.out.println(janek.suma());
        System.out.println();
        System.out.println(marke.suma());

        //1. Napisz metodę, która przyjmuje tablicę liczb całkowitych i zwraca sumę wszystkich elementów.
        int[] listaLiczb = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Suma liczb z listy = " + sumaLiczZListy(listaLiczb));
        System.out.println();

        //2. Napisz metodę, która znajduje największy element w tablicy.
        System.out.println("Najwiekszy element w tablicy = " + najwiekszaLiczba(listaLiczb));
        System.out.println();

        //3. Napisz metodę, która znajduje najmniejszy element w tablicy.
        System.out.println("Najmniejszy element w tablicy = " + najmnieszyElement(listaLiczb));
        System.out.println();

        //4. Napisz metodę, która oblicza średnią wartość elementów w tablicy.
        System.out.println("Srednia z tablicy = " + srednia(listaLiczb));
        System.out.println();

        //5. Napisz metodę, która liczy ile elementów w tablicy jest większych od podanej liczby x.
        System.out.println("Wiekszych elementow w tablicy jest = " + iloscLiczWiekszychOdX(listaLiczb, 5));
        System.out.println();

        //6. Napisz metodę, która zlicza ile w tablicy jest liczb parzystych.
        System.out.println("Wiekszych elementow w tablicy jest = " + iloscLiczbParzystychWTablicy(listaLiczb));
        System.out.println();

        //7. Napisz metodę, która tworzy nową tablicę zawierającą tylko liczby parzyste z oryginalnej tablicy.
        System.out.println("Nowa Lista z parzystymi liczbami = " + Arrays.toString(nowaListaTylkoZParzystymiLiczbami(listaLiczb)));
        System.out.println();

        //8. Napisz metodę, która odwraca kolejność elementów w tablicy.
        System.out.println("Odwrocone elemety = " + Arrays.toString(odworconaLista(listaLiczb)));
        System.out.println();

        //9. Napisz metodę, która sprawdza czy tablica zawiera podaną liczbę.
        System.out.println("Czy posiada wybrany element = " + wybranaLiczba(listaLiczb, 22));
        System.out.println();

        //10. Napisz metodę, która zlicza ile razy dana liczba występuje w tablicy.
        System.out.println("Ile razy wystepuje dana liczba w tbalicy " + mapaWystepowaniaLicz(listaLiczb));
        System.out.println();

        //11. Napisz metodę, która znajduje indeks największego elementu w tablicy.
        System.out.println("Index pod ktorym znajduje sie najwieksza liczba = " + indexZNajwiekszaLiczba(listaLiczb));
        System.out.println();

        //12. Napisz metodę, która tworzy nową tablicę zawierającą elementy większe od średniej wartości tablicy.
        System.out.println("Nowa Tablica z elementami wiekszymi od sredniej = " + Arrays.toString(nowaTablicaZwiekszaOdSredniej(listaLiczb)));
        System.out.println();

        //13. Napisz metodę, która zamienia wszystkie liczby ujemne w tablicy na 0.
        int[] listaLiczb1 = {-1, -2, -3, 4, 5, 6, 7, 8};
        System.out.println("Zamienia wszystkie ujemne liczby w tablicy na 0 = " + Arrays.toString(zmianaNaZeroUjemnychLiczb(listaLiczb1)));
        System.out.println();

        //14. Napisz metodę, która przesuwa wszystkie elementy tablicy o jedno miejsce w prawo (ostatni element trafia na początek).
        System.out.println("Przesuniecie o jeden w prawo = " + Arrays.toString(przesuwamyWPrawo(listaLiczb1)));
        System.out.println();

        //15. Napisz metodę, która przesuwa wszystkie elementy tablicy o jedno miejsce w lewo (pierwszy element trafia na koniec).
        System.out.println("Przesuniecie w lewo = " + Arrays.toString(przesuwamyWLewo(listaLiczb)));
        System.out.println();

        //16. Napisz metodę, która sprawdza czy tablica jest posortowana rosnąco.
        int[] listaLiczb3 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Czy jest rosnaca = " + czyJestRosnaca(listaLiczb3));
        System.out.println();

        //17. Napisz metodę, która znajduje drugi największy element w tablicy.
        System.out.println("Drugi najwiekszy element w tablicy = " + drugiNajwiekszyElementWTablicy(listaLiczb3));
        System.out.println();

        //18. Napisz metodę, która scala dwie tablice w jedną większą tablicę.
        System.out.println("Scalanie tablic = " + Arrays.toString(nowaScalonaTablica(listaLiczb1, listaLiczb3)));
        System.out.println();

        //19. Napisz metodę, która usuwa wszystkie wystąpienia danej liczby z tablicy (zwraca nową tablicę).
        System.out.println("Scalanie tablic = " + Arrays.toString(nowaListaBezDanejLiczby(listaLiczb3, 5)));
        System.out.println();

        //20. Napisz metodę, która sprawdza czy dwie tablice są identyczne (mają te same elementy w tej samej kolejności).
        int[] tablica4 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] tablica5 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] tablica6 = {1, 2, 44, 4, 55, 6, 7, 8};
        System.out.println("Porownywanie tablic = " + porowanieLiczbWTablicach(tablica4, tablica5));
        System.out.println();
        System.out.println("Porownywanie tablic = " + porowanieLiczbWTablicach(tablica4, tablica6));
        System.out.println();

        //21. Napisz metodę, która znajduje element najbliższy średniej wartości tablicy.
        System.out.println("Element najblizysz sredniej wartosci z tablicy = " + liczbaNajblizszaSredniejZTablicy(tablica4));
        System.out.println();

        //22. Napisz metodę, która znajduje najdłuższą rosnącą sekwencję kolejnych elementów w tablicy.  *


        //23. Napisz metodę, która sprawdza czy tablica zawiera duplikaty.
        int[] tablica7 = {18, 2, 44, 4, 55, 6, 6, 7, 8};
        System.out.println("Sprawdzanie czy lista posiada duplikaty = " + sprawdzanieDuplikatowWLiscie(tablica7));
        System.out.println();

        //24. Napisz metodę, która zwraca tablicę zawierającą tylko unikalne elementy z oryginalnej tablicy. *

        //25. Napisz metodę, która dla każdej liczby w tablicy zwraca jej kwadrat w nowej tablicy.
        System.out.println("Nowa lista podniesiona do z liczbami do kwadratu = " + Arrays.toString(tablicaPodniesionaDoKwadratu(tablica4)));
        System.out.println();

        //26. Napisz metodę, która zamienia miejscami pierwszy i ostatni element tablicy.
        System.out.println("Zamiana elementow = " + Arrays.toString(zamianaElementow(tablica4)));
        System.out.println();

        //27. Napisz metodę, która sprawdza czy tablica jest palindromem (czyta się tak samo od przodu i od tyłu).
        int[] tablica9 = {1, 2, 3, 4, 3, 2, 1};
        System.out.println("Sprawdzenie czy lista jest palindromem = " + czyListaJestPalindromem(tablica9));
        System.out.println();
        System.out.println("Sprawdzenie czy lista jest palindromem = " + czyListaJestPalindromem(tablica7));
        System.out.println();

        //28. Napisz metodę, która znajduje różnicę między największym a najmniejszym elementem tablicy.
        System.out.println("Tablica = " + Arrays.toString(tablica7));
        System.out.println("Roznica miedzy najwiekszym a najmniejszym elementem = ");
        rozniaMiedzyNajwieszykmANajmnieszymElementem(tablica7);
        System.out.println();

        //29. Napisz metodę, która zwraca indeks pierwszego elementu większego od podanej liczby.
        System.out.println("Index pierwszej wiekszeej od liczby = " + indexKolejnegoNastepnejLiczbyZTablicy(tablica9,3));
        System.out.println();

        //30. Napisz metodę, która sortuje tablicę rosnąco bez użycia wbudowanych metod sortowania. *


    }

    //30. Napisz metodę, która sortuje tablicę rosnąco bez użycia wbudowanych metod sortowania. *



    //29. Napisz metodę, która zwraca indeks pierwszego elementu większego od podanej liczby.
    public static int indexKolejnegoNastepnejLiczbyZTablicy(int[] tablica, int liczba ) {
        int index = 0;
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] > liczba) {
                index = i;
            }
        }
        return index;
    }


    //28. Napisz metodę, która znajduje różnicę między największym a najmniejszym elementem tablicy.
    public static void rozniaMiedzyNajwieszykmANajmnieszymElementem(int[] tablica) {
        int roznia = 0;
        int najwiekszyElementTablicy = tablica[0];
        int najmniejszyElementTablicy = tablica[0];
            for (int liczba : tablica) {
                if (liczba > najwiekszyElementTablicy) {
                    najwiekszyElementTablicy = liczba;
                }
                if (liczba < najmniejszyElementTablicy) {
                    najmniejszyElementTablicy = liczba;
                }
            roznia = najwiekszyElementTablicy - najmniejszyElementTablicy;
        }
        System.out.println("Najwiekszy = " + najwiekszyElementTablicy);
        System.out.println("Najmniejszy = " + najmniejszyElementTablicy);
        System.out.println("Roznica = " + roznia);
    }

    //27. Napisz metodę, która sprawdza czy tablica jest palindromem (czyta się tak samo od przodu i od tyłu).
    public static boolean czyListaJestPalindromem(int[] tablica) {
        for (int i = 0; i < tablica.length / 2; i++) {
            if (tablica[i] != tablica[tablica.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    //26. Napisz metodę, która zamienia miejscami pierwszy i ostatni element tablicy.
    public static int[] zamianaElementow(int[] tablica) {
        int pierwszy = tablica[0];
        int ostatni = tablica[tablica.length - 1];
        for (int i = 0; i < tablica.length; i++) {
            tablica[0] = ostatni;
            tablica[tablica.length - 1] = pierwszy;
        }
        return tablica;
    }

    //25. Napisz metodę, która dla każdej liczby w tablicy zwraca jej kwadrat w nowej tablicy.
    public static int[] tablicaPodniesionaDoKwadratu(int[] tablica) {
        int[] nowaTablica = new int[tablica.length];
        for (int i = 0; i < tablica.length; i++) {
            nowaTablica[i] = tablica[i] * tablica[i];
        }
        return nowaTablica;
    }


    //24. Napisz metodę, która zwraca tablicę zawierającą tylko unikalne elementy z oryginalnej tablicy.
    public static int[] tablicaBezDuplikatow(int[] tablica) {
        int licznik = 0;
        int[] nowaTablica = new int[licznik];
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica.length; j++) {
                if (tablica[i] != tablica[j]) {
                    licznik++;
                }
                nowaTablica[i] = tablica[i];
            }
        }
        return nowaTablica;
    }


    //23. Napisz metodę, która sprawdza czy tablica zawiera duplikaty.
    public static boolean sprawdzanieDuplikatowWLiscie(int[] tablica) {
        for (int i = 0; i < tablica.length; i++) {
            for (int j = i + 1; j < tablica.length; j++) {
                if (tablica[i] == tablica[j]) {
                    return true;
                }
            }
        }
        return false;
    }


    //21. Napisz metodę, która znajduje element najbliższy średniej wartości tablicy.
    public static int liczbaNajblizszaSredniejZTablicy(int[] tablica) {
        double suma = 0;
        for (int i = 0; i < tablica.length; i++) {
            suma += tablica[i];
        }

        double srednia = suma / tablica.length;

        int najblizsza = tablica[0];
        double minRoznica = Math.abs(tablica[0] - srednia);

        for (int i = 1; i < tablica.length; i++) {
            double roznica = Math.abs(tablica[i] - srednia);
            if (roznica < minRoznica) {
                minRoznica = roznica;
                najblizsza = tablica[i];
            }
        }
        return najblizsza;
    }

    //20. Napisz metodę, która sprawdza czy dwie tablice są identyczne (mają te same elementy w tej samej kolejności).
    public static boolean porowanieLiczbWTablicach(int[] tablica1, int[] tablica2) {
        if (tablica1.length != tablica2.length) {
            return false;
        }
        for (int i = 0; i < tablica1.length; i++) {
            if (tablica1[i] != tablica2[i]) {
                return false;
            }
        }
        return true;
    }


    //19. Napisz metodę, która usuwa wszystkie wystąpienia danej liczby z tablicy (zwraca nową tablicę).
    public static int[] nowaListaBezDanejLiczby(int[] tablica1, int liczba) {
        int licznik = 0;
        for (int i = 0; i < tablica1.length; i++) {
            if (tablica1[i] != liczba) {
                licznik++;
            }
        }

        int[] nowaTablica = new int[licznik];
        int j = 0;
        for (int i = 0; i < tablica1.length; i++) {
            if (tablica1[i] != liczba) {
                nowaTablica[j] = tablica1[i];
                j++;
            }
        }
        return nowaTablica;
    }

    //18. Napisz metodę, która scala dwie tablice w jedną większą tablicę.
    public static int[] nowaScalonaTablica(int[] tablica1, int[] tablica2) {
        int[] nowaTablica = new int[tablica1.length + tablica2.length];
        for (int i = 0; i < tablica1.length; i++) {
            nowaTablica[i] = tablica1[i];
        }
        for (int i = 0; i < tablica2.length; i++) {
            nowaTablica[tablica1.length + i] = tablica2[i];
        }
        return nowaTablica;
    }


    public static int drugiNajwiekszyElementWTablicy(int[] tablica) {
        int pierwszyNajwiekszy = Integer.MIN_VALUE;
        int drugiNajwiekszy = Integer.MIN_VALUE;
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] > pierwszyNajwiekszy) {
                drugiNajwiekszy = pierwszyNajwiekszy;
                pierwszyNajwiekszy = tablica[i];
            } else if (tablica[i] > drugiNajwiekszy && tablica[i] != pierwszyNajwiekszy) {
                drugiNajwiekszy = tablica[i];
            }
        }
        return drugiNajwiekszy;
    }


    public static boolean czyJestRosnaca(int[] tablica) {
        System.out.println(Arrays.toString(tablica));
        for (int i = 1; i < tablica.length; i++) {
            if (tablica[i] < tablica[i - 1]) {
                return false;
            }
        }
        return true;
    }


    public static int[] przesuwamyWLewo(int[] tablica) {
        int pierwszyElement = tablica[0];
        for (int i = 0; i < tablica.length - 1; i++) {
            tablica[i] = tablica[i + 1];
        }
        tablica[tablica.length - 1] = pierwszyElement;
        return tablica;
    }


    public static int[] przesuwamyWPrawo(int[] tablica) {
        int ostatni = tablica[tablica.length - 1];
        for (int i = tablica.length - 1; i > 0; i--) {
            tablica[i] = tablica[i - 1];
        }
        tablica[0] = ostatni;
        return tablica;
    }

    public static int[] zmianaNaZeroUjemnychLiczb(int[] tablica) {
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] < 0) {
                tablica[i] = 0;
            }
        }
        return tablica;
    }

    public static int[] nowaTablicaZwiekszaOdSredniej(int[] tablica) {
        int sumaLiczbZtablicy = 0;
        int srednia = 0;
        for (int i = 0; i < tablica.length; i++) {
            sumaLiczbZtablicy += tablica[i];
        }
        srednia = sumaLiczbZtablicy / tablica.length;
        System.out.println("Srednia = " + srednia);

        int licznik = 0;
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] > srednia) {
                licznik++;
            }
        }
        int[] nowaTablica1 = new int[licznik];
        int index = 0;

        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] > srednia) {
                nowaTablica1[index] = tablica[i];
                index++;
            }
        }
        return nowaTablica1;
    }

    public static int indexZNajwiekszaLiczba(int[] liczba) {
        int index = 0;
        int max = liczba[0];
        for (int i = 0; i < liczba.length; i++) {
            if (liczba[i] > max) {
                max = liczba[i];
                index = i;
            }
        }
        return index;
    }

    public static HashMap<Integer, Integer> mapaWystepowaniaLicz(int[] tablica) {
        HashMap<Integer, Integer> mapa = new HashMap<>();
        for (int liczba : tablica) {
            if (mapa.containsKey(liczba)) {
                mapa.put(liczba, mapa.get(liczba) + 1);
            } else {
                mapa.put(liczba, 1);
            }
        }

        return mapa;
    }

    public static boolean wybranaLiczba(int[] tablica, int liczba) {
        for (int liczbaZtablicy : tablica) {
            if (liczbaZtablicy == liczba) {
                return true;
            }
        }
        return false;
    }

    public static int[] odworconaLista(int[] tablica) {
        int[] nowaTablica = new int[tablica.length];
        for (int i = 0; i < tablica.length; i++) {
            nowaTablica[i] = tablica[tablica.length - 1 - i];
        }
        return nowaTablica;
    }

    public static int[] nowaListaTylkoZParzystymiLiczbami(int[] tablica) {
        int licznik = 0;
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] % 2 == 0) {
                licznik++;
            }
        }
        int[] nowaTablica = new int[licznik];
        int index = 0;

        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] % 2 == 0) {
                nowaTablica[index] = tablica[i];
                index++;
            }
        }
        return nowaTablica;
    }

    public static int iloscLiczWiekszychOdX(int[] tablica, int x) {
        int ilosc = 0;
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] > x) {
                ilosc++;
            }
        }
        return ilosc;
    }

    public static int iloscLiczbParzystychWTablicy(int[] tablica) {
        int ilosc = 0;
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] % 2 == 0) {
                ilosc++;
            }
        }
        return ilosc;
    }


    public static int liczbaWiekszychLiczbOdX(int[] tablica, int liczba) {
        int ilosc = 0;
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] > liczba) {
                ilosc++;
            }
        }
        return ilosc;
    }


    public static int srednia(int[] tablica) {
        int srednia = 0;
        for (int i = 0; i < tablica.length; i++) {
            srednia += tablica[i];
        }
        return srednia / tablica.length;
    }

    public static int sumaLiczZListy(int[] tablica) {
        int suma = 0;
        for (int i = 0; i < tablica.length; i++) {
            suma += tablica[i];
        }
        return suma;
    }

    public static int najwiekszaLiczba(int[] tablica) {
        int najwiekszaLiczba = 0;
        int liczba1 = tablica[0];
        for (int liczba : tablica) {
            if (liczba > liczba1) {
                najwiekszaLiczba = liczba;
            }
        }
        return najwiekszaLiczba;
    }

    public static int najmnieszyElement(int[] tablica) {
        int najwiekszaLiczba = tablica[0];
        for (int liczba : tablica) {
            if (liczba < najwiekszaLiczba) {
                najwiekszaLiczba = liczba;
            }
        }
        return najwiekszaLiczba;
    }

    public static int suma(List<int[]> lista) {
        int suma = 0;
        for (int i = 0; i < lista.size(); i++) {
            for (int k = 0; k < lista.get(i).length; k++) {
                suma += lista.get(i)[k]; //[1,2,3]
            }
        }
        return suma;
    }


    public static List<Integer> listaBezNieparzystych(List<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) % 2 != 0) {
                lista.remove(lista.get(i));
                i--;
            }
        }
        return lista;
    }


}
//napisz funkcje ktora usuwa wszystkie liczby nieparzyste z listy
//napisz funkcje ktora przyjmuje liste tablic intow i oblicz sume wszystkich elementow
//Stworz klase Person ktora robi zakupy (Product(name,price)) jedna osoba kupuje wiele produktow
//napisz funkcje ktora obliczy sume wydanych pieniedzy przez osobe