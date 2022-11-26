package kirillnasyrov.models.chip;

public class Chip {
    private Color color;

    public Chip(String arg) {
        color = arg.equals("white") ? Color.White : Color.Black;
    }

    public String getColor() {
        return color.toString();
    }

    public void changeColor() {
        color = color == Color.White ? Color.Black : Color.White;
    }
}
