package stream.stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx01 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("jason");
        names.add("xml");
        names.add("spring");
        names.add("stream");


        List<String> collect = names.stream()
                .map((s) -> {
                    System.out.println(s +"  " +Thread.currentThread().getName());
                    return s.toUpperCase();
                }).collect(Collectors.toList());
        collect.forEach(System.out::println);


    }
}
