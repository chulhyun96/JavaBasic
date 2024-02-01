package stream.method_reference;

public class Member {
    private static String name;
    public Member() {}
    public Member(String name) {
        this.name = name;
    }
    public String greet(String name) {
        return "Hi " + name;
    }
    public static String introduce(String name) {
        return "Hello I'm" + name;
    }
}
