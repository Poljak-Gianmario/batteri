package children;
import main.Food;

public class Scolari extends main.Batterio{

    private boolean goDown;
    private boolean moveVertical;
    private boolean goRight;
    private boolean moveHorizontal;


    public Scolari() {
        goDown = getRandomBoolean();
        goRight = getRandomBoolean();
        moveVertical = getRandomBoolean();
        moveHorizontal = getRandomBoolean();
        if (!moveVertical)
            moveHorizontal= true;
    }

    @Override
    protected void move() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (Food.isFood(getX() - i, getY() - j)) {
                    if (i != 0)
                        x--;
                    if (j != 0)
                        y--;
                    return;
                }
                if (Food.isFood(getX() - i, getY() + j)) {
                    if (i != 0)
                        x--;
                    if (j != 0)
                        y++;
                    return;
                }
                if (Food.isFood(getX() + i, getY() - j)) {
                    if (i != 0)
                        x++;
                    if (j != 0)
                        y--;
                    return;
                }
                if (Food.isFood(getX() + i, getY() + j)) {
                    if (i != 0)
                        x++;
                    if (j != 0)
                        y++;
                    return;
                }
            }

        }
        if (moveVertical) {
            if (goDown) {
                y++;
                if (y > Food.getHeight()) {
                    goDown = false;
                    y = Food.getHeight() - 1;
                }
                return;
            } else {
                y--;
                if (y < 0) {
                    goDown = true;
                    y = 0;
                }
                return;
            }
        }
        if (moveHorizontal) {
            if (goRight) {
                x++;
                if (x > Food.getWidth()) {
                    goRight = false;
                    x = Food.getWidth() - 1;
                }
                return;
            } else {
                x--;
                if (x < 0) {
                    goRight = true;
                    x = 0;
                }
                return;
            }
        }
    }
    private static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }


    @Override
    public main.Batterio clone() throws CloneNotSupportedException {
        Scolari clone = (Scolari)super.clone();
        return clone;
    }

}
