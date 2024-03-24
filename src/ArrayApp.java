import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ArrayApp {
    public static void main(String[] args) {
        int size = 5000;
        int[] array = new int[size];
        Random rand = new Random();

        IntStream.range(0, size).forEach(i -> array[i] = rand.nextInt());
        long start = System.nanoTime();
        Arrays.sort(array);
        long takeTime1 = (System.nanoTime() - start);
        System.out.println("Serial sort : " + (System.nanoTime() - start));

        IntStream.range(0, size).forEach(i -> array[i] = rand.nextInt());
        start = System.nanoTime();
        Arrays.parallelSort(array);
        long takeTime2 = (System.nanoTime() - start);
        System.out.println("Parallel sort : " + (System.nanoTime() - start));


        // 더 느린게 츨력됨.
        if (takeTime1 > takeTime2) {
            System.out.println("Serial sort : " + takeTime1);
        } else {
            System.out.println("Parallel sort : " +takeTime2);
        }



    }
}
