package children;
import main.Food;
public class Terminator extends main.Batterio{
    private boolean goDown;
    private boolean goLeft;

    public Terminator() {
        goDown = true;
        goLeft = true;
    }

    @Override
    protected void move() {
        if (goDown) {
            y++;
            if (y > Food.getHeight()) {
                goDown = false;
                y = Food.getHeight() - 1;
            }
        } else {
             y--;
            if (y < 0) {
                goDown = true;
                y = 0;
            }
        }

        if (goLeft) {
            x++;
            if (x > Food.getHeight()) {
                goLeft = false;
                x = Food.getHeight() - 1;
            }
        } else {
            x--;
            if (x < 0) {
                goLeft = true;
                x = 0;
            }
        }


    }
    @Override
    public main.Batterio clone() throws CloneNotSupportedException {
        Terminator clone = (Terminator) super.clone();
        clone.goDown = !goDown;
        return clone;
    }
}