package stream.method_reference;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodRefConstructor {
    public static void main(String[] args) {
        Supplier<Member> create = Member::new;
        Member member = create.get();
        String joGreeting = member.greet("Jo");
        System.out.println(joGreeting);



        // 임의의 객체 메서드 참조!?!?
        String[] asd = {"zxc1", "asd1", "zxc3"};
        Arrays.sort(asd, String::compareToIgnoreCase);
        for (String zxc : asd) {
            System.out.println(zxc);
        }

        // 스태틱 메서드
        UnaryOperator<String> greeting = Member::introduce;
        String apply = greeting.apply(" Jo");
        System.out.println(apply);

    }
}
