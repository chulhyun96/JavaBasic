package stream.reason;

import java.util.Arrays;
import java.util.List;

public class StreamGoodReason {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        // 1. 원소들의 시퀀스를 일관되게 변환한다. (모든 과일 이름을 대문자로 변환)
        List<String> upperCaseFruits = fruits.stream()
                .map(String::toUpperCase)
                .toList();

        // 2. 원소들의 시퀀스를 필터링한다. (길이가 5보다 큰 과일 이름만 필터링)
        List<String> filteredFruits = fruits.stream()
                .filter(fruit -> fruit.length() > 5)
                .toList();

        // 3. 원소들의 시퀀스를 하나의 연산을 사용해 결합한다. (모든 과일 이름을 하나의 문자열로 결합)
        String concatenatedFruits = fruits.stream()
                .reduce("", (acc, fruit) -> acc + fruit + ",");

        // 4. 원소들의 시퀀스를 컬렉션에 모은다. (위 코드에서 이미 사용됨)

        // 5. 원소들의 시퀀스에서 특정 조건을 만족하는 원소를 찾는다. (길이가 정확히 5인 첫 번째 과일을 찾는다)
        String fiveLetterFruit = fruits.stream()
                .filter(fruit -> fruit.length() == 5)
                .findFirst()
                .orElse(null);

        System.out.println("Uppercase Fruits: " + upperCaseFruits);
        System.out.println("Filtered Fruits: " + filteredFruits);
        System.out.println("Concatenated Fruits: " + concatenatedFruits);
        System.out.println("Five Letter Fruit: " + fiveLetterFruit);


        List<String> stringsList = List.of("java", "Sptring", "asdw", "sdg");
        String collect = String.join(",", stringsList);
        System.out.println("collect = " + collect);


    }
}
