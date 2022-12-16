package kirillnasyrov;

import kirillnasyrov.models.ConsoleReader;

public class Main {

    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        String str1 = reader.getFilePath();
        String str2 = reader.getFilePath();
        System.out.println(str1 + " " + str2);
    }
}
