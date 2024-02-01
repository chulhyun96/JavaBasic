package exception.try_catch01;

public class UncheckedException {
    public static void main(String[] args) {

        try {
            double a = 2 / 0;

        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());

        }
        System.out.println("끝");
    }
}
