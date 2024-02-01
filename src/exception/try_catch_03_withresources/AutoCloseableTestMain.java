package exception.try_catch_03_withresources;

import java.io.FileNotFoundException;

public class AutoCloseableTestMain {
    public static void main(String[] args) {
        AutoCloseableTest act = new AutoCloseableTest();

        try (act){
            throw new FileNotFoundException();

        } catch (FileNotFoundException e) {
            System.out.println("파일이 없는데??");
        }
        catch (Exception e) {
            System.out.println("파일은 있는데 예외가 발생하였고 close 메서드가 호출된걸 알 수 있음");
        }
    }
}

