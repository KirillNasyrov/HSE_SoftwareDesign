package kirillnasyrov;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String path = "C:/HSE/file.txt";
        FileIterator iterator = null;
        try {
            iterator = new FileIterator(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
