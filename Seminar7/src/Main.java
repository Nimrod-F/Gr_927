import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {

    public static void filterByLetter(List<String> list, Character letter) {

        list.stream().map(s -> s.toUpperCase()).
                filter(s -> s.length() < 4).filter(s -> s.contains(String.valueOf(letter))).
                findFirst().ifPresent(System.out::println);
    }

    public static void main(String[] args) {

        //p1
        List<String> words = Arrays.asList("hi", "hello", "yess", "boss", "eee", "ye");
        //words.stream().forEach((s) -> System.out.println("  " + s);

        //System.out.println();

//        List<String> words2 = words.stream().map((s) -> ".." + s).toList();
//
//        words2.stream().forEach((s) -> System.out.println("  " + s));


        //p2
        words.stream().forEach(System.out::println);
        //p3
        List<String> words2, words3, words4;
        words2 = words.stream().map((s) -> s + "!").toList();
        words3 = words.stream().map(s -> s.replace("i", "eye")).toList();
        words4 = words.stream().map(String::toUpperCase).toList();
        words2.stream().forEach(System.out::println);
        words3.stream().forEach(System.out::println);
        words4.stream().forEach(System.out::println);
        // P4
        System.out.println("P4");
        List<String> shortWords = words.stream().filter((s) -> s.length() < 4).toList();
        List<String> wordsWithB = words.stream().filter((s) -> s.contains("b")).toList();
        List<String> evenLengthWords = words.stream().filter((s) -> s.length() % 2 == 0).toList();
        shortWords.stream().forEach(System.out::println);
        wordsWithB.stream().forEach(System.out::println);
        evenLengthWords.stream().forEach(System.out::println);

        //P5
        System.out.println("P5");
        words.stream().map(s -> s.toUpperCase()).
                filter(s -> s.length() < 4).filter(s -> s.contains("E")).
                findFirst().ifPresent(System.out::println);

        words.stream().map(s -> s.toUpperCase()).
                filter(s -> s.length() < 4).filter(s -> s.contains("Q")).
                findFirst().ifPresent(System.out::println);

        filterByLetter(words, 'S');

        // P6
        System.out.println(words
                .stream()
                .reduce("", (acc, elem) -> acc + elem.toUpperCase()));

        // P7
        System.out.println(words.stream().map(String::toUpperCase).reduce("", (acc, elem) ->
                acc + elem));

        // P8
        System.out.println("P8");
        words.stream().reduce((firstWord, secondWord) -> firstWord + ',' + secondWord)
                .ifPresent(System.out::println);

//        System.out.println(
//                words.stream().reduce("", (acc, word) -> acc + ',' + word)
//        );

        System.out.println(words.stream().collect(Collectors.joining(",")));

        // P9
        System.out.println(words.stream().map(String::length).reduce(0, (acc, word) -> acc + word));
        System.out.println(words.stream().reduce(0, (acc, word) -> acc + word.length(), Integer::sum));
        System.out.println(words.stream().mapToInt(String::length).sum());

        // P10
        System.out.println(words.stream().filter(s->s.contains("h")).count());
    }
}