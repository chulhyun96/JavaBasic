package stream.stream_api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("-------spring 으로 시작하는 수업---------------");
        // TODO

        List<OnlineClass> list = keesunEvents.stream()
                .flatMap(Collection::stream)
                .filter(c -> c.getTitle().startsWith("spring"))
                .toList();
        for (OnlineClass onlineClass : list) {
            System.out.println("기선리스트" + onlineClass.getTitle());
        }


        System.out.println("----------------------------------------------");


        System.out.println("-----------------close 되지 않은 수업----------------");
        // TODO
        // 두가지 방법이 존재한다. Predicate.not 함수형 인터페이스 호출 및 !연산자 사용하기
        List<OnlineClass> notClosedClassesAboutSpring = springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .toList();
        for (OnlineClass notClosedClass : notClosedClassesAboutSpring) {
            System.out.println("isNotClosedSpring = " + notClosedClass.getTitle());
        }

        List<OnlineClass> notClosedClassesAboutJava = javaClasses.stream()
                .filter(jc -> !jc.isClosed())
                .toList();
        for (OnlineClass onlineClass : notClosedClassesAboutJava) {
            System.out.println("isNotClosedJava = " + onlineClass.getTitle());
        }

        List<OnlineClass> list1 = keesunEvents.stream()
                .flatMap(Collection::stream)
                .filter(Predicate.not(OnlineClass::isClosed))
                .toList();
        for (OnlineClass onlineClass : list1) {
            System.out.println("기선 클래스 = " + onlineClass.getTitle());
        }

        System.out.println("----------------------------------------------");


        System.out.println("--------------------수업 이름만 모아서 스트림 만들기------------------");
        // TODO
        List<String> springClassesNames = springClasses.stream()
                .map(OnlineClass::getTitle)
                .toList();
        for (String springClassesName : springClassesNames) {
            System.out.println("springClassesNames = " + springClassesName);
        }
        List<String> javaClassesNames = javaClasses.stream()
                .map(OnlineClass::getTitle)
                .toList();
        for (String javaClassesName : javaClassesNames) {
            System.out.println("javaClassesNames = " + javaClassesName);
        }

        System.out.println("----------------------------------------------");


        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        // TODO
        List<Integer> idList = keesunEvents.stream()
                .flatMap(Collection::stream)
                .map(OnlineClass::getId)
                .toList();

        for (Integer i : idList) {
            System.out.println("class ID  = " + i);
        }


        System.out.println("----------------------------------------------");

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        // TODO
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);
        System.out.println("----------------------------------------------");


        System.out.println("--------------------------자바 수업 중에 Test가 들어있는 수업이 있는지 확인--------------------------");
        // TODO
        /*boolean test = javaClasses.stream()
                .filter(jc -> jc.getTitle().contains("Test"))
                        .allMatch(javaClasses.stream());*/

        boolean b = keesunEvents.stream()
                .flatMap(Collection::stream)
                .anyMatch(oc -> oc.getTitle().contains("Test"));

        System.out.println("any Match " + b);

        System.out.println("----------------------------------------------");


        System.out.println("-------------------스프링 수업 중에 제목에 spring 제목이들어간 것만 모아서 List로 만들기-------------------");
        // TODO
        List<String> springNames = springClasses.stream()
                .filter(sc -> sc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .toList();

        for (String springName : springNames) {
            System.out.println("springNameList: " + springName);
        }
        System.out.println("----------------------------------------------");

    }

}
