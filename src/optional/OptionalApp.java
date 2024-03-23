package optional;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalApp {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(c -> c.getTitle().startsWith("spring"))
                .findFirst();

        /*boolean empty = spring.isPresent();
        System.out.println("empty = " + empty);
        */

        spring.ifPresent(oc -> System.out.println("title = " + oc.getTitle()));

        OnlineClass onlineClass = spring.orElseThrow();
        System.out.println(onlineClass.getTitle());
    }

    private static OnlineClass createNewClass() {
        System.out.println("OptionalApp.createNewClass");
        return new OnlineClass(10,"JPA release", false);
    }
}
