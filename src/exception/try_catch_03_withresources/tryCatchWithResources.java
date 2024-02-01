package exception.try_catch_03_withresources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class tryCatchWithResources {
    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("src/text")) {

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("끝");
    }
}
