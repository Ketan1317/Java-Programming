
import java.util.*;

public class Streams {

    public static void main(String[] args) {
// Streams API :
// A Stream is a sequence of elements that supports functional operations.
// 1. Stream does not store data
// 2. It processes data from collections

        // Basic Stream Flow :
        // Collection → Stream → Operations → Result
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().filter(x -> x % 2 == 0).forEach(System.out::println);

        // filter() -> 
        // 1. Filters elements based on condition
        // 2. Returns stream
        list.stream().filter(x -> x > 3).forEach(System.out::println);

        // map() -> 
        // 1.Transforms data
        // 2.One element → another element
        list.stream().map(x -> x * x).forEach(System.out::println);

        // reduce() ->
        // Reduces multiple elements to single value
        int sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

    }
}
