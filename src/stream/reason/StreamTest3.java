package stream.reason;

import java.util.List;
import java.util.stream.IntStream;

public class StreamTest3 {
    public static void main(String[] args) {
        List<Integer> devidedNum = List.of(1,2,3,4,5,6,7,8);

        int devidedNumber = 0;
/*
        double sum = 0.0;
        for (int a :devidedNum) {
            sum += a / devidedNumber;
        }
        System.out.println(sum);

*/

        IntStream.range(0, devidedNum.size())
                .mapToDouble(i -> devidedNum.get(i) / devidedNumber)
                .sum();

    }
}
