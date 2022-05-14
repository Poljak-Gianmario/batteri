package children;

import main.Food;

import java.util.Random;

public class EscherichiaColi extends main.Batterio{

    private boolean goDown, goUp, goLeft, goRight;
    private int n;

    public EscherichiaColi() {
        this.goDown = Math.random() < 0.5;
        this.goUp = Math.random() < 0.5;
        this.goLeft = Math.random() < 0.5;
        this.goRight = Math.random() < 0.5;
    }

    @Override
    public main.Batterio clone() throws CloneNotSupportedException {
        EscherichiaColi clone = (EscherichiaColi) super.clone();
        clone.goDown = !goDown;
        clone.goLeft = !goLeft;
        clone.goUp = !goDown;
        clone.goRight = !goLeft;
        return clone;
    }

    @Override
    protected void move() throws Exception {
        n = (int)(Math.random()*10);
        if (n == 1){
            goDown = Math.random() < 0.5;
            goUp = Math.random() < 0.5;
            goLeft = Math.random() < 0.5;
            goRight = Math.random() < 0.5;
        }
        if (goDown) {
            y++;
            if (y > Food.getHeight()) {
                goDown = false;
                goLeft = Math.random() < 0.5;
                goRight = !goLeft;
                goUp = true;
                y = Food.getHeight() - 1;
            }
        }
        else {
            y--;
            if (y < 0) {
                goUp = false;
                goLeft = Math.random() < 0.5;
                goRight = !goLeft;
                goDown = true;
                y = 0;
            }
        }

        if (goRight) {
            x++;
            if (x > Food.getWidth()) {
                goRight = false;
                goDown = Math.random() < 0.5;
                goUp = !goDown;
                goLeft = true;
                y = Food.getWidth() - 1;
            }
        }
        else {
            x--;
            if (x < 0) {
                goLeft = false;
                goDown = Math.random() < 0.5;
                goUp = !goDown;
                goRight = true;
                x = 0;
            }
        }

    }
}
