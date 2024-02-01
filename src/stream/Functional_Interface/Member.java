package stream.Functional_Interface;

public class Member {
    private String name;

    @Override
    public String toString() {
        return "저의 이름은 " + this.name +" 입니다";
    }

    public String getName() {
        return name;
    }

    public Member(String name) {
        this.name = name;
    }
}
