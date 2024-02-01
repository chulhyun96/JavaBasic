package stream.method_reference;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public class MethodRefInstance {
    public static void main(String[] args) {
        //특정 객체의 인스턴스 메서드 참조방식
        Member member = new Member();

        UnaryOperator<String> m1 = member::greet;
        String result = m1.apply("Jo");
        System.out.println("result = " + result);


        UnaryOperator<String> m2 = name -> member.greet(name);
        String result2 = m2.apply("Jo2");
        System.out.println("result2 = " + result2);

        String[] names = {"Jo", "Park", "Kim"};
        Arrays.sort(names, String::compareToIgnoreCase);

        for (String name : names) {
            System.out.println(name);
        }
    }
}
