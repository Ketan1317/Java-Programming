
import java.util.ArrayList;
import java.util.List;

public class GenericsPlusLambda {

    public static void main(String[] args) {
        // lambda functions, Runnable is an functional interface (single function interface) having only function run.
        Runnable r = () -> System.out.println("Running");
        // ✔ No parameters
        // ✔ No return value for runnable
        r.run();

        // create your own functional interface
        @FunctionalInterface
        interface Sum { // interface declaration

            int add(int a, int b); // abstract function of interface
        }

        Sum s = (a, b) -> a + b;
        System.out.println(s.add(1, 3));
        List<?> list = new ArrayList<>();

        // GENERICS -> 
        class Box<T> {
            T value;
        }
        // Usage: 
        Box<Integer> b = new Box<>();

        // Bounded Generics -> <T extends Number>
        // It Accepts Integer, Double, etc.



    }
}
