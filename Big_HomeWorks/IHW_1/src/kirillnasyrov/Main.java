package kirillnasyrov;

import kirillnasyrov.models.field.Field;
import kirillnasyrov.view.ConsolePainter;

public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        ConsolePainter.repaint(field);
    }
}
