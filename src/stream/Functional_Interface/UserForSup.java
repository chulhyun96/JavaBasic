package stream.Functional_Interface;

public class UserForSup {
    private String name;

    public UserForSup(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserForSup{" +
                "name='" + name + '\'' +
                '}';
    }
}
