package stream.Functional_Interface;

import java.util.function.Function;

public class FunctionalExample {
    public static void main(String[] args) {
        Function<Integer, Integer> function1 = i -> i + 10;
        Function<Integer, Integer>  function2 = i -> i * 2;

        Integer apply1 = function1.compose(function2).apply(2);
        System.out.println("apply1 = " + apply1);

        Integer apply2 = function1.andThen(function2).apply(2);
        System.out.println("apply2 = " + apply2);

        Member member1 = new Member("James");
        Member member2 = new Member("Fox");
        Member member3 = new Member("Ele");
        Member member4 = new Member("Joo");



        Function<String, String> trim = String::trim;
        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> replaceSpaces = str -> str.replace(" ", "_");


        // 데이터 정규화: 공백 제거 -> 대문자 변환 -> 공백을 언더스코어로 변경
        String normalize = trim.andThen(toUpperCase)
                .andThen(replaceSpaces).apply(" hello world!!");

        System.out.println("normalize = " + normalize);

    }
}
