import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8,9,10,11,12,14,15,16);

        String values = numbers.stream().filter(nr -> nr % 3 == 0 || nr % 2 == 0).map(nr -> "A" + (nr + 1) + "B").collect(Collectors.joining());
        System.out.println(values);

        int result = numbers.stream().filter(nr -> nr % 4 != 0).map(nr ->  (nr + 1) ).reduce(0, (acc, nr) -> (acc + nr)%2);
        System.out.println(result);
    }
}