package stream.reason;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest1 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Grimoire", "Wizard", "Magic", "Spell");

        // 중간 연산: filter()와 map() - 아직 실행되지 않음
        var filteredMappedStream = words.stream()
                .filter(word -> word.length() > 5)
                .map(String::toUpperCase);


        List<String> result = filteredMappedStream.collect(Collectors.toList());

        System.out.println(result); // [GRIMOIRE, WIZARD]

    }
}
