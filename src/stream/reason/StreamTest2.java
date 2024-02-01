package stream.reason;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest2 {
    public static void main(String[] args) {
        List<String> list = Stream.of("a", "ab", "abc", "abcd", "abcde")
                .filter(item -> item.length() >= 2)
                .map(String::toUpperCase)
                .limit(3)
                .collect(Collectors.toList());

        for (String item : list) {
            System.out.println(item);
        }

        List<String> list1 = Stream.of("a", "ab", "abc", "abcd", "abcde")
                .filter(item -> {
                    System.out.println("[filter]" + item);
                    return item.length() >= 2;
                })
                .map(item -> {
                    System.out.println("[map]" + item);
                    return item.toUpperCase();
                })
                .limit(3)
                .collect(Collectors.toList());
        for (String item : list1) {
            System.out.println(item);
        }

        System.out.println("스트림 사용 XXXX");
        int count = 0 ;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).length() >= 2) {
                count++;
                String upperCase = list1.get(i).toUpperCase();
                System.out.println(upperCase);
                if (count > 3) {
                    break;
                }
            }
        }

    }
}
