package exception.pw_exception;

public class PwTest {

    public static PwTest validate(String pw) throws PWException {
        if (pw == null) {
            throw new PWException("Pw can't be null");
        } else if (pw.length() > 5) {
            throw new PWException("Pw can't be over 6 you pushed " + pw.length() );
        } else if (pw.matches("[a-zA-Z]+")) {
            throw new PWException("Pw can't include only letter" );
        } else {
            System.out.println("Success");
        }
        return null;
    }
}
