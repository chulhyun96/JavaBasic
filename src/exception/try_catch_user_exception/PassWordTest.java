package exception.try_catch_user_exception;

public class PassWordTest {
    static class PassWord {
        String pw;
        public PassWord(String pw) throws PassWordExceptionTest {
            validatePw(pw);
            this.pw = pw;
        }

        public String getPw() {
            return pw;
        }

        //null일수 없으며, 5글자 이상, 문자로만 이루어져서는 안된다.
        // (숫자 및 특수문자가 반드시 포함되어야 함)
        public void validatePw(String pw) throws PassWordExceptionTest {
            if (pw == null) {
                throw new PassWordExceptionTest("Pw can't be null");
            } else if (pw.length() > 5) {
                throw new PassWordExceptionTest("Pw can't be over 6 you pushed " + pw.length() );
            } else if (pw.matches("[a-zA-Z]+")) {
                throw new PassWordExceptionTest("Pw can't include only letter" );
            }
            printSuccess(pw);
        }

        public void printSuccess(String pw) {
            System.out.println("pw = " + pw + " pw 형식 일치 성공!!");
        }
    }
    public static void main(String[] args) {
        try {
         PassWord pw = new PassWord("123456");
        } catch (PassWordExceptionTest e) {
            System.out.println(e.getMessage());
        }
    }
}
