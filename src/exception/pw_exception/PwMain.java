package exception.pw_exception;

public class PwMain {
    public static void main(String[] args) {
        try {
            String pw = "asd23";
            PwTest.validate(pw);
        } catch (PWException e) {
            System.out.println(e.getMessage());
        }
    }
}
