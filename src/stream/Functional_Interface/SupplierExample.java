package stream.Functional_Interface;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> 10;
        Integer i = supplier.get();
        System.out.println("i = " + i);

        Supplier<Integer> randomNum = () -> new Random().nextInt(100);
        Integer i1 = randomNum.get();
        System.out.println("i1 = " + i1);


        Supplier<LocalDateTime> timeSupplier = LocalDateTime::now;
        LocalDateTime currentTime = timeSupplier.get();
        System.out.println(currentTime);

        UnaryOperator<Integer> asd = x -> x+x;
        Integer apply = asd.apply(5);
        System.out.println("apply = " + apply);

        Predicate<Integer> predicate = x -> x > 2;
        boolean test = predicate.test(3);
        System.out.println("test = " + test);


        Predicate<String> string = str1 -> str1.startsWith("S");
        boolean test1 = string.test("Source");
        System.out.println("test1 = " + test1);




    }
}
