package children;
import main.Food;

public class Scolari extends main.Batterio{

    private boolean goDown;
    private boolean moveVertical;
    private boolean goRight;
    private boolean moveHorizontal;
    private int mosse;


    public Scolari() {
        x = ((int) (Math.random() * 10000)) % Food.getWidth();
        y = ((int) (Math.random() * 10000)) % Food.getHeight();
        mosse = 0;
        goDown = getRandomBoolean();
        goRight = getRandomBoolean();
        moveVertical = getRandomBoolean();
        moveHorizontal = getRandomBoolean();
        if (!moveVertical)
            moveHorizontal= true;
    }

    @Override
    protected void move() {
        mosse++;
        if (mosse == 500){
            mosse = 0;
            goDown = getRandomBoolean();
            goRight = getRandomBoolean();
            moveVertical = getRandomBoolean();
            moveHorizontal = getRandomBoolean();
            if (!moveVertical)
                moveHorizontal= true;
        }
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < i; j++) {
                if (Food.isFood(getX() - i, getY() + j)) {
                    x-= i;
                    y+= j;
                    return;
                }
                if (Food.isFood(getX() + i, getY() - j)) {
                    x+= i;
                    y-= j;
                    return;
                }
                if (Food.isFood(getX() - i, getY() - j)) {
                    x-= i;
                    y-= j;
                    return;
                }
                if (Food.isFood(getX() + i, getY() + j)) {
                    x+= i;
                    y+= j;
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
