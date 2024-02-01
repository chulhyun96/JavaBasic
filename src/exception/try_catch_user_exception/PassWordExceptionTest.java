package exception.try_catch_user_exception;

public class PassWordExceptionTest extends Exception{

    public PassWordExceptionTest(String message) {
        //해당 메서드는 getMessege를 출력해주는 생성자 메서드
        //Exception의 메서드임.
        super(message);
    }
}
