package children;
import main.Batterio;
import main.Food;
public class Terminator extends main.Batterio{
    private boolean goDown;
    private boolean goLeft;

    public Terminator() {
        int a = (int) (Math.random() * 1000);
        if(a < 250)
        {
            x = 300;
            y = 300;
        }

        if(a > 250 && a < 500 )
        {
            x = 550;
            y = 300;
        }

        if(a > 500 && a < 750)
        {
            x = 700;
            y = 700;
        }

        if(a > 750 && a < 1000)
        {
            x = 400;
            y = 400;
        }

        if(Math.random() > 0.5)
            goDown = true;
        else
        goDown = false;

        if(Math.random() > 0.5)
            goLeft = true;
        else
            goLeft = false;

    }

    @Override
    protected void move() {

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < i; j++) {
                if (Food.isFood(getX() - i, getY() - j)) {
                    x-= i;
                    y-= j;
                    return;
                }
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
                if (Food.isFood(getX() + i, getY() + j)) {
                    x+= i;
                    y+= j;
                    return;
                }
            }

        }

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