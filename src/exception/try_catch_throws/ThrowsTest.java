package exception.try_catch_throws;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsTest {
    public Class testThrowsException(String filePath, String className) throws FileNotFoundException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filePath);
        Class c = Class.forName(className);
        return c;
    }
    public static void main(String[] args) {
        ThrowsTest tt = new ThrowsTest();
        try {
            tt.testThrowsException("src/a","java.lang.String");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
