import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.function.Consumer;



public interface Lambda {
        public void setup();
        public default void run () {
            System.out.println("Hello Tester");
        }
        public static void main(String[] args) {
            Lambda test = () -> {
                System.out.println("Setup environment in here");
            };
            test.setup();
            test.run();

            // Example Lambda
            List names = Arrays.asList("java", "Spring", "Hibernate");
            names.forEach((name)-> System.out.println(name));

            //Example Lambda have argument
            Consumer<String> greet = name  -> System.out.println("Hi"+ name );
            greet.accept("Nguyen");

            // Example Lambda with interface
            @FunctionalInterface
            interface MathOperation{
                int hahaoperate(int a,int b);
            }

            MathOperation multiply = (a,b) -> a*b;
            System.out.println(multiply.hahaoperate(5,4));
            // Example Predicate
            List<String> pets = new ArrayList<>(Arrays.asList("dog","cat","bird","pit"));
            Predicate<String> StartWithD = name -> name.startsWith("d");
            List<String> filtered = pets.stream().filter(StartWithD).collect(Collectors.toList());
            System.out.println(filtered);
        }
}


