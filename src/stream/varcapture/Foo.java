package stream.varcapture;


import java.util.function.IntConsumer;

public class Foo {
    public static void main(String[] args) {
        Foo foo = new Foo();
        getRun();
    }

    private static void getRun() {
        int baseNumber= 10;
        IntConsumer printInt = i -> {
            System.out.println(i + baseNumber);
        };
        printInt.accept(10);
    }

}
