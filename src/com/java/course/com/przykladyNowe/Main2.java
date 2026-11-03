package com.java.course.com.przykladyNowe;

public class Main2 {
    public static void main(String[] args) {
        //1. Napisz program, który wypisze na ekranie Twoje imię i nazwisko 10 razy
        //2. Napisz program, ktory wypisze wszystkie liczby od 1 do 99
        //3. Napisz program, ktory wypisze wszystkie liczby od 99 do 1
        //4. Napisz program, ktory wypisze wszystkie liczby parzyste od 1 do 100 ale w jednej linii oddzielone spacja
        //5 Korzystajac z petli while wypisz wszystkie liczby nieparzyste od 1 do 100
        //6. Napisz program, który obliczy sumę wszystkich liczb od 1 do 100.
        //7. Napisz program, który obliczy silnię liczby 5.
        //8. Napisz program, który wygeneruje i wypisze pierwsze 10 liczb ciągu Fibonacciego.
        //9. Napisz program, który dla danej liczby n wypisze wszystkie liczby od n do 0 w kolejności malejącej.
        //10. Napisz program, który wypisze tabliczkę mnożenia dla liczb od 1 do 10.
        //11. Napisz program, który wypisze wszystkie liczby podzielne przez 3 w zakresie od 1 do 100.
        //12. Napisz program, który prosi użytkownika o wpisanie liczby, a następnie wypisze tę liczbę tyle razy, ile wynosi jej wartość.
        //13. Napisz program, który wypisze "Hello World!" 100 razy, każde powitanie w nowej linii.
        //14. Napisz program, który wyświetli kwadraty liczb od 1 do 20.
        //15. Napisz program, który wyświetli litery alfabetu od 'a' do 'z'.
        //16. Napisz program, który wyświetli litery alfabetu od 'z' do 'a'.
        //17. Napisz program ktory narysuje trojkat z gwiazdek '*' o wysokosci 5
        //18. Napisz program ktory wypisze sume cyfry jednosci i dziesiatek wszystkich liczb od 10 do 99
        //https://www.youtube.com/watch?v=yJs1VMzOl_I&ab_channel=JavaStart
        //19. oblicz silnie dla liczby 5

        //1. Napisz program, który wypisze na ekranie Twoje imię i nazwisko 10 razy
        System.out.println("Zadnaie 1:");
        String imie = "Radek";
        imieXrazy(imie,11);
        System.out.println();

        //2. Napisz program, ktory wypisze wszystkie liczby od 1 do 99
        System.out.println("Zadanie 2:");
        liczbyOdXdoX(1,99);

        //3. Napisz program, ktory wypisze wszystkie liczby od 99 do 1
        System.out.println("Zadanie 3:");
        liczbyMalejaceOdDo(99,0);
        System.out.println();

        //4. Napisz program, ktory wypisze wszystkie liczby parzyste od 1 do 100 ale w jednej linii oddzielone spacja
        System.out.println("Zadanie 4:");
        liczbyParzyste(100);
        System.out.println();

        //5 Korzystajac z petli while wypisz wszystkie liczby nieparzyste od 1 do 100
        System.out.println("Zadnie 5:");
        int x = 1;
        while (x <= 100) {
            if (x % 2 != 0) {
                System.out.print(x + " ");
            }
            x++;
        }
        System.out.println();

        //6. Napisz program, który obliczy sumę wszystkich liczb od 1 do 100.
        System.out.println("Zadnie 6:");
        int suma = 0;
        for (int i = 1; i <=100 ; i++) {
            suma+= i;
        }
        System.out.println("Suma = " + suma);
        System.out.println();

        //7. Napisz program, który obliczy silnię liczby 5.
        System.out.println("Zadnie 7");
        int liczba = 5;
        int silnia = 1;
        for (int i = 1; i <= liczba; i++) {
            silnia *= i;
        }
        System.out.println("Silnia z " + liczba + " = " + silnia);
        System.out.println();

        //8. Napisz program, który wygeneruje i wypisze pierwsze 10 liczb ciągu Fibonacciego.
        System.out.println("Zadanie 8:");
        int n = 10;
        int a = 0;
        int b = 1;
        System.out.print("Ciąg Fibonacciego: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");

            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();

        //9. Napisz program, który dla danej liczby n wypisze wszystkie liczby od n do 0 w kolejności malejącej.
        System.out.println("Zadanie 9:");
        int n1 = 15;
        for (int i = n1; i >= 0; i--) {
            System.out.print(i + " ");
        }

        //10. Napisz program, który wypisze tabliczkę mnożenia dla liczb od 1 do 10.
        System.out.println("Zadanie 10:");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print((i * j) + "\t");
            }
            System.out.println();
        }
        System.out.println();

        //11. Napisz program, który wypisze wszystkie liczby podzielne przez 3 w zakresie od 1 do 100.
        System.out.println("Zadanie 11:");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        //12. Napisz program, który prosi użytkownika o wpisanie liczby, a następnie wypisze tę liczbę tyle razy, ile wynosi jej wartość.
        System.out.println("Zadanie 12:");
        System.out.println("Podaj liczbe:");
        /*Scanner scanner = new Scanner(System.in);
        int liczbaUzytkownika = scanner.nextInt();
        for (int i = 1; i <= liczbaUzytkownika; i++) {
            System.out.print(liczbaUzytkownika + " ");
        }
         */

        //13. Napisz program, który wypisze "Hello World!" 100 razy, każde powitanie w nowej linii.
        String witajSwiecie = "Hello World";
        System.out.println("Zadanie 13:");
        for (int i = 1; i <=100; i++) {
            System.out.println(witajSwiecie + " numer = " + i);
        }

        //14. Napisz program, który wyświetli kwadraty liczb od 1 do 20.
        System.out.println();
        System.out.println("Zadanie 14");
        for (int i = 1; i <= 20; i++) {
            System.out.println("Kwadrat liczby = " + i +" " + (i*i));
        }
        System.out.println();

        //15. Napisz program, który wyświetli litery alfabetu od 'a' do 'z'.
        System.out.println("Zadanie 15:");
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.println("Litera alfabetu = " + i);
        }
        System.out.println();

        //16. Napisz program, który wyświetli litery alfabetu od 'z' do 'a'.
        System.out.println("Zadanie 16:");
        for (char i = 'z'; i >= 'a'; i--) {
            System.out.println("Litera alfabetu = " + i);
        }
        System.out.println();

        //17. Napisz program ktory narysuje trojkat z gwiazdek '*' o wysokosci 5
        System.out.println("Zadanie 17:");
        int len = 5;
        for (int i = len; i > 0 ; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 2 * (len - i) + 1; k > 0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        //18. Napisz program ktory wypisze sume cyfry jednosci i dziesiatek wszystkich liczb od 10 do 99
        System.out.println("Zadanie 18:");
        int sumaLiczb = 0;

        for (int i = 10; i <= 99; i++) {
            int dziesiatki = i / 10;   // cyfra dziesiątek
            int jednosci = i % 10;     // cyfra jedności
            sumaLiczb += dziesiatki + jednosci;
        }

        System.out.println("Suma cyfr = " + sumaLiczb);
        System.out.println();

        //19. oblicz silnie dla liczby 5
        System.out.println("Zadanie 19");
        int liczba5 = 5;
        int silnia1 = 1;

        for (int i = 1; i <= liczba5; i++) {
            silnia1 *= i;
        }

        System.out.println("Silnia z " + liczba5 + " = " + silnia1);

    }

    public static void imieXrazy(String imie, int iloscPowtorzen) {
        for (int i = 1; i < iloscPowtorzen ; i++) {
            System.out.println("nr" + i + " " + imie);
        }
    }

    public static void liczbyOdXdoX(int liczbaOd, int liczbaDo) {
        for (int i = liczbaOd; i <= liczbaDo; i++ ) {
            System.out.println("Liczba = " + i);
        }
    }

    public static void liczbyMalejaceOdDo(int liczbaOd, int liczbaDo) {
        for (int i = liczbaOd; i > liczbaDo; i-- ) {
            System.out.println("Liczba = " + i);
        }
    }

    public static void liczbyParzyste(int licbza) {
        System.out.print("Liczby: ");
        for (int i = 0; i <= licbza; i++ ) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
