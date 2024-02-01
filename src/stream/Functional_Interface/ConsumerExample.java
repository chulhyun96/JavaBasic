package stream.Functional_Interface;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        Consumer<String> printConsumer = (s) -> System.out.println(s);
        names.forEach(printConsumer);
        printConsumer.accept(names.toString());

    }
}
