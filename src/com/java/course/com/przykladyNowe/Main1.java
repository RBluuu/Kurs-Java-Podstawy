package com.java.course.com.przykladyNowe;

import java.util.Random;

public class Main1 {
    public static void main(String[] args) {
        //Zadania:
        //1. Napisz program, który wypisze na ekranie Twoje imię i nazwisko
        //2. Napisz program, który wypisze na ekranie Twoje imię i nazwisko oraz wiek
        //3. Napisz program, który wypisze na ekranie Twoje imie,nazwisko,wiek,wzrost,plec, i czy miales juz stycznosc z programowaniem
        //4. Zaprezentuj wszystkie operacje arytmetyczne (dodawanie, odejmowanie, mnożenie, dzielenie, modulo)
        //5. Napisz program, ktory obliczy pole prostokata o bokach 5 i 10
        //6. Napisz program, ktory obliczy pole koła o promieniu 5
        //7. Napisz program, ktory obliczy twoje bmi (wzor: waga/(wzrost*wzrost))
        //8* Napisz program ktory wylosuje dwie liczby z zakresu 1-100 i sprawdzi ile wynosi ich roznica oraz czy ta roznica jest parzysta
        //9. Powtorz zadanie nr 3 ale korzystajac z System.out.printf
        //10.Napisz dowolne slowo 3 razy w 3 rzedach korzystajac z System.out.print
        //11.Wyjustuj kod
        //12.Wymien wszystkie typy danych jakie znasz
        //13.Napisz prorgam ktory obliczy ile finalnie wyniesie cena auta w leasingu jesli:
        //    cena auta to 100 000
        //    leasing trwa 5 lat
        //    oprocentowanie wynosi 5%
        //    wplacasz 10% wartosci auta
        //14.Napisz program ktory obliczy ile lat zajmie Ci splacenie kredytu hipotecznego jesli:
        //    wartosc kredytu to 500 000
        //    oprocentowanie wynosi 3%
        //    splacasz 1000 zl miesiecznie


        //1. Napisz program, który wypisze na ekranie Twoje imię i nazwisko
        System.out.println("Zadanie1: ");
        String imie = "Radek";
        String nazwisko = "Błauciak";
        System.out.println(imie + " " + nazwisko);
        System.out.println();

        //2. Napisz program, który wypisze na ekranie Twoje imię i nazwisko oraz wiek
        int wiek = 31;
        System.out.println("Zdanie2: ");
        System.out.println(imie + " " + wiek + " lat");
        System.out.println();

        //3. Napisz program, który wypisze na ekranie Twoje imie,nazwisko,wiek,wzrost,plec, i czy miales juz stycznosc z programowaniem
        int wzrost = 178;
        String plec = "mezyczna";
        String kontaktZProgramowaniem = "TAK";
        System.out.println("Zadanie3: ");
        System.out.println("Imiec: " + imie + " Nazwisko: " + nazwisko + " Wiek: " + wiek + " Wzrost: " + wzrost + " Plec: " + plec + " Kontakt z programowaniem: " + kontaktZProgramowaniem);
        System.out.println();

        //4. Zaprezentuj wszystkie operacje arytmetyczne (dodawanie, odejmowanie, mnożenie, dzielenie, modulo)
        System.out.println("Zadanie4 :");
        int liczbaNR1 = 2;
        int liczbaNR2 = 5;
        System.out.println("Dodawanie = " + (liczbaNR1 + liczbaNR2));
        System.out.println("Odejmowanie = " + (liczbaNR2 - liczbaNR1));
        System.out.println("Mnozenie = " + liczbaNR1 * liczbaNR2);
        System.out.println("Dzielenie = " + (liczbaNR2 / liczbaNR1));
        System.out.println("Modulu = " + liczbaNR2 % liczbaNR1);
        System.out.println();

        //5. Napisz program, ktory obliczy pole prostokata o bokach 5 i 10
        System.out.println("Zadanie5 :");
        int bokA = 5;
        int bokB = 10;
        System.out.println("Pole prostokata = " + poleProstokata(bokA, bokB));
        System.out.println();

        //6. Napisz program, ktory obliczy pole koła o promieniu 5
        System.out.println("Zadanie6 :");
        double promien = 5;
        System.out.println("Pole kola o promieniu 5 = " + poleKola(5));
        System.out.println();

        //7. Napisz program, ktory obliczy twoje bmi (wzor: waga/(wzrost*wzrost))
        System.out.println("Zadanie7: ");
        int waga = 105;
        double wzrostRadek = 1.78;
        System.out.println("Moje BMI = " + mojeBMI(waga, wzrostRadek));
        System.out.println();

        //8* Napisz program ktory wylosuje dwie liczby z zakresu 1-100 i sprawdzi ile wynosi ich roznica oraz czy ta roznica jest parzysta
        System.out.println("Zadanie8 : ");
        Random random = new Random();
        int liczba1 = random.nextInt(100) + 1;
        int liczba2 = random.nextInt(100) + 1;
        System.out.println("Czy liczba jest parzysta z roznicy liczby NR1 i NR2 = " + czyLiczbaParzysta(liczba1, liczba2) + " liczby = " + liczba1 + " i " + liczba2);
        System.out.println();

        //9. Powtorz zadanie nr 3 ale korzystajac z System.out.printf
        System.out.println("Zadanie9: ");
        System.out.printf("Imie %s, " + "Nazwisk %s", imie, nazwisko);
        System.out.println();

        //10.Napisz dowolne slowo 3 razy w 3 rzedach korzystajac z System.out.print
        System.out.println("Zadanie10 :");
        System.out.println("radek\n" + "radek\n" + "radek\n");
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println("Radek\n");
        }
        System.out.println();

        //11.Wyjustuj kod
        //Ctrl + Alt + L

        //12.Wymien wszystkie typy danych jakie znasz
        // int double char float boolean short byte long

        //13.Napisz prorgam ktory obliczy ile finalnie wyniesie cena auta w leasingu jesli:
        //    cena auta to 100 000
        //    leasing trwa 5 lat
        //    oprocentowanie wynosi 5%
        //    wplacasz 10% wartosci auta
        System.out.println("Zadanie 13:");
        int cenaAuta = 100_000;
        int leasing = 5;
        double oprocentowanie = 0.05;
        int cenaWplaty = cenaAuta / 10;
        System.out.println("Cena auta w leasingu = " + cenaAutaLeasingowego(cenaAuta,leasing,oprocentowanie,cenaWplaty)+" ZŁ");
        System.out.println();


        //14.Napisz program ktory obliczy ile lat zajmie Ci splacenie kredytu hipotecznego jesli:
        //    wartosc kredytu to 500 000
        //    oprocentowanie wynosi 3%
        //    splacasz 1000 zl miesiecznie
        System.out.println("Zadanie 14:");
        int kwotaKredytu = 500_000;
        double oprocentowanieKredytu = 0.03;
        int rataKredytu = 1000;
        System.out.println("Splacenie kredytu zajmie = " + dlugoscKredytu(kwotaKredytu,oprocentowanieKredytu,rataKredytu) + " lat");


    }

    public static double dlugoscKredytu(int kwota, double oprocentowanie, int rataKredytu) {
        double calkowitaKwota = kwota + kwota*oprocentowanie;
        double miesiecy = calkowitaKwota / rataKredytu;
        return miesiecy / 12;
    }

    public static double poleProstokata(int a, int b) {
        return a * b;
    }

    public static double poleKola(int promien) {
        return Math.PI * (promien * promien);
    }

    public static double mojeBMI(int waga, double wzrost) {
        return waga / (wzrost * wzrost);
    }

    public static boolean czyLiczbaParzysta(int a, int b) {
        return (a - b) % 2 == 0;
    }

    public static int cenaAutaLeasingowego(int cena, double leasing, double oprocentowanie, int wplata) {
        return (int) (((cena*oprocentowanie) * leasing) + wplata + cena);
    }


}
