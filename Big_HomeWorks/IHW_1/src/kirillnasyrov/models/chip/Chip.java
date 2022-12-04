package kirillnasyrov.models.chip;

/**
 * Класс, описывающий фишку
 */
public class Chip {
    private Color color;

    public Chip(Color value) {
        color = value == Color.White ? Color.White : Color.Black;
    }

    public Color getColor() {
        return color;
    }

    public void changeColor() {
        color = color == Color.White ? Color.Black : Color.White;
    }
}
