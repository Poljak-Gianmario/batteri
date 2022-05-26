package children;

import main.Batterio;
import main.Food;

public class Palalalà extends main.Batterio{
    private boolean goDown ;
    private boolean goRight;

    public Palalalà() {
        goDown = true;
        goRight = true;
    }

    //move "principale"
    @Override
    protected void move() throws Exception {
        int r = (int) (Math.random() * 2 + 1);

        if (r == 1){
            if (goDown) {
                y++;
                if (y > Food.getHeight()) {
                    goDown = false;
                    y = Food.getHeight() - 1;
                }
                for(int i = 0; i < 20; i++) {
                    for (int j = 0; j < 20; i++){
                        if(Food.isFood(x-i,y-j)){
                            x-=i;
                            y-=j;
                            break;
                        }
                        if(Food.isFood(x+i,y-j)){
                            x+=i;
                            y-=j;
                            break;
                        }
                        if(Food.isFood(x-i,y+j)){
                            x-=i;
                            y+=j;
                            break;
                        }
                        if(Food.isFood(x+i,y+j)){
                            x+=i;
                            y+=j;
                            break;
                        }
                        break;
                    }
                }
            }
            else {
                y--;
                if (y < 0) {
                    goDown = true;
                    y = 0;
                }
            }
        }

        else if (r == 2){
            if (goRight) {
                x++;
                if (x > Food.getWidth()) {
                    goRight = false;
                    x = Food.getWidth() - 1;
                }
                for(int i = 0; i < 20; i++) {
                    for (int j = 0; j < 20; i++){
                        if(Food.isFood(x-i,y-j)){
                            x-=i;
                            y-=j;
                            break;
                        }
                        if(Food.isFood(x+i,y-j)){
                            x+=i;
                            y-=j;
                            break;
                        }
                        if(Food.isFood(x-i,y+j)){
                            x-=i;
                            y+=j;
                            break;
                        }
                        if(Food.isFood(x+i,y+j)){
                            x+=i;
                            y+=j;
                            break;
                        }
                        break;
                    }
                }
            }
            else {
                x--;
                if (x < 0) {
                    goRight = true;
                    x = 0;
                }
            }
        }
    }

    //move alternativa
//    @Override
//    protected void move() throws Exception {
//        int r = (int) (Math.random() * 2 + 1);
//
//        if (r == 1){
//            if (goDown) {
//                y++;
//                if (y > Food.getHeight()) {
//                    goDown = false;
//                    y = Food.getHeight() - 1;
//                }
//            } else {
//                y--;
//                if (y < 0) {
//                    goDown = true;
//                    y = 0;
//                }
//            }
//        }
//
//        else if (r == 2){
//            if (goRight) {
//                x++;
//                if (x > Food.getWidth()) {
//                    goRight = false;
//                    x = Food.getWidth() - 1;
//                }
//            } else {
//                x--;
//                if (x < 0) {
//                    goRight = true;
//                    x = 0;
//                }
//            }
//        }
//    }



    public Batterio clone() throws CloneNotSupportedException {
        Palalalà clone = (Palalalà)super.clone();
        clone.goDown = !goDown;
        clone.goRight = !goRight;
        return clone;
    }
}
