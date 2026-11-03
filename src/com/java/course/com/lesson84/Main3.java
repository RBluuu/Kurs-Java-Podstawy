package com.java.course.com.lesson84;

public class Main3 {
    public static void main(String[] args) {
        /*
        // Znajdź sumę wszystkich liczb parzystych z listy.
        public static int sumaParzyste(List<Integer> lista) {
            return Optional.ofNullable(lista)
                    .orElse(Collections.emptyList())
                    .stream()
                    .filter(Objects::nonNull)
                    .filter(n -> n % 2 == 0)
                    // co tu wstawić żeby zwrócić int?
        }
         */

        /*
        Posortuj listę napisów: najpierw według długości rosnąco,
        przy równej długości — alfabetycznie.
        public static List<String> sortujNapisy(List<String> lista) {
            return Optional.ofNullable(lista)
                    .orElse(Collections.emptyList())
                    .stream()
                    .filter(Objects::nonNull)
                    .sorted(/* co tu wstawić? )
                    .collect(Collectors.toList());
            }
         */
    /*
    // Zwróć listę wszystkich słów ze wszystkich zdań,
// bez duplikatów, posortowaną alfabetycznie.
// Wejście: ["ala ma kota", "kota ma ala"]
// Wyjście: ["ala", "kota", "ma"]
public static List<String> wszystkieSłowa(List<String> zdania) {
    return Optional.ofNullable(zdania)
            .orElse(Collections.emptyList())
            .stream()
            .filter(Objects::nonNull)
            // jak rozbić zdania na słowa?
}
     */
        /*
        // Sprawdź czy lista liczb tworzy ciąg ściśle rosnący
// (każdy element WIĘKSZY od poprzedniego, równe niedozwolone).
// [1,2,3] → true
// [1,2,2] → false
public static boolean sciscleRosnacy(List<Integer> lista) {
    // jak poprawnie porównać sąsiednie elementy?
}
         */

        /*
        // Znajdź słowo, które pojawia się najczęściej na liście.
// Przy remisie zwróć dowolne z nich.
public static String najczestszeSłowo(List<String> lista) {
    // wskazówka: potrzebujesz Map<String, Long>, potem max po wartości
}
         */


    }

    /*
    Zwracające wartość pojedynczą
OperacjaZwracaOpiscount()
long Liczy elementy w strumieniusum()
int/long/doubleSuma — tylko na IntStream/LongStream/DoubleStreamaverage()OptionalDoubleŚrednia — tylko na strumieniach prymitywnychmin(Comparator)Optional<T>Najmniejszy element według komparatoramax(Comparator)Optional<T>Największy element według komparatorafindFirst()Optional<T>Pierwszy element strumieniafindAny()Optional<T>Dowolny element — szybszy przy strumieniach równoległych
Zwracające boolean
OperacjaZwracaOpisanyMatch(Predicate)booleanCzy którykolwiek element spełnia warunekallMatch(Predicate)booleanCzy wszystkie elementy spełniają waruneknoneMatch(Predicate)booleanCzy żaden element nie spełnia warunku
java// Przykład
List<Integer> lista = List.of(1, 2, 3, 4, 5);

lista.stream().anyMatch(n -> n > 4);   // true  — 5 spełnia
lista.stream().allMatch(n -> n > 0);   // true  — wszystkie > 0
lista.stream().noneMatch(n -> n > 10); // true  — żaden nie > 10
Zwracające kolekcję — collect()
collect() sam w sobie zwraca Object — jego wynik zależy od przekazanego Collector:
CollectorZwracaOpisCollectors.toList()List<T>Zbiera do listyCollectors.toSet()Set<T>Zbiera do setu, usuwa duplikatyCollectors.toMap(k, v)Map<K,V>Zbiera do mapyCollectors.groupingBy(f)Map<K, List<T>>Grupuje elementy według funkcjiCollectors.groupingBy(f, Collectors.counting())Map<K, Long>Grupuje i liczyCollectors.counting()LongLiczy elementy w grupieCollectors.joining()StringŁączy Stringi w jedenCollectors.joining(", ")StringŁączy Stringi separatoremCollectors.summingInt(f)IntegerSumuje po przekształceniuCollectors.averagingInt(f)DoubleŚrednia po przekształceniuCollectors.toUnmodifiableList()List<T>Niemodyfikowalna lista
javaList<String> lista = List.of("ala", "ma", "kota", "i", "psa");

// toList
lista.stream().collect(Collectors.toList());
// → ["ala", "ma", "kota", "i", "psa"]

// groupingBy — długość słowa
lista.stream().collect(Collectors.groupingBy(String::length));
// → {3→["ala", "psa"], 2→["ma", "i"], 4→["kota"]}  ← uwaga: "i" ma length=1

// groupingBy + counting
lista.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
// → {1→1, 2→1, 3→2, 4→1}

// joining
lista.stream().collect(Collectors.joining(", "));
// → "ala, ma, kota, i, psa"

// summingInt
lista.stream().collect(Collectors.summingInt(String::length));
// → 14
Zwracające void
OperacjaZwracaOpisforEach(Consumer)voidWykonuje akcję na każdym elemencieforEachOrdered(Consumer)voidJak forEach, ale zachowuje kolejność przy strumieniach równoległych
javalista.stream().forEach(System.out::println); // drukuje każdy element
Zwracające tablicę
OperacjaZwracaOpistoArray()Object[]Zbiera do tablicy obiektówtoArray(T[]::new)T[]Zbiera do tablicy konkretnego typu
javaString[] tablica = lista.stream().toArray(String[]::new);
Reduce — elastyczna redukcja
OperacjaZwracaOpisreduce(BinaryOperator)Optional<T>Redukuje bez wartości początkowejreduce(T, BinaryOperator)TRedukuje z wartością początkową
java// Suma przez reduce
List.of(1,2,3,4,5).stream()
    .reduce(0, Integer::sum);   // → 15

// Iloczyn
List.of(1,2,3,4,5).stream()
    .reduce(1, (a, b) -> a * b); // → 120

Skrócona ściąga
Potrzebuję...                    Użyj...
─────────────────────────────────────────────────
policzyć elementy              → count()
znaleźć max/min                → max() / min()
znaleźć pierwszy/dowolny       → findFirst() / findAny()
sprawdzić warunek              → anyMatch / allMatch / noneMatch
zebrać do listy                → collect(Collectors.toList())
zebrać do mapy                 → collect(Collectors.toMap())
pogrupować                     → collect(Collectors.groupingBy())
połączyć Stringi               → collect(Collectors.joining())
zsumować                       → mapToInt(...).sum() lub reduce()
wykonać akcję na elementach    → forEach()

Chcę...                                    Użyj...
──────────────────────────────────────────────────────────────
zebrać do List                           → toList()
zebrać do Set                            → toSet()
zebrać do Map                            → toMap(klucz, wartość)
pogrupować do Map<K, List<T>>            → groupingBy(funkcja)
pogrupować i policzyć Map<K, Long>       → groupingBy(f, counting())
podzielić na true/false                  → partitioningBy(warunek)
połączyć Stringi                         → joining(separator)
zsumować                                 → summingInt/Long/Double
policzyć                                 → counting()
     */
}
