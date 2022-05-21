package children;

import main.Food;

import java.util.Random;

public class EscherichiaColi extends main.Batterio{

    private boolean goDown, goRight;
    private int n;

    public EscherichiaColi() {
        this.goDown = false;
        this.goRight = true;
    }

    @Override
    public main.Batterio clone() throws CloneNotSupportedException {
        EscherichiaColi clone = (EscherichiaColi) super.clone();
        clone.goDown = !goDown;
        clone.goRight = !goRight;
        return clone;
    }

    @Override
    protected void move() throws Exception{
        n = (int) (Math.random() * 2 + 1);
        if (n == 1) {
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
        }

        if (n == 2) {
            if (goRight) {
                x++;
                if (x > Food.getWidth()) {
                    goRight = false;
                    y = Food.getWidth() - 1;
                }
            } else {
                x--;
                if (x < 0) {
                    goRight = true;
                    x = 0;
                }
            }
        }

    }

}
