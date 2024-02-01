package exception.try_catch_03_withresources;

public class AutoCloseableTest implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("close() called");
    }

}
