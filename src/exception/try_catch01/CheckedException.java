package exception.try_catch01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedException {
    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream fis = new FileInputStream("asd");
    }
}
