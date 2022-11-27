package kirillnasyrov.view;


import kirillnasyrov.models.field.Field;

public class ConsolePainter {
    public static void repaint(Field field) {
        for (int i = 0; i < 8; ++i) {
            System.out.println("---------------------------------");
            for (int j = 0; j < 8; ++j) {
                if (field.getCell((char)(97 + i), j + 1).isEmpty()) {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("---------------------------------");
    }
}
