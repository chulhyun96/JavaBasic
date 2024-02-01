package exception.try_catch02_finally;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryCatchFianlly {
    public static void main(String[] args) {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/text");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        } finally {
            System.out.println("finally");
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("끝");
        }

    }
}
