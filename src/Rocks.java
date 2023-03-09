import java.awt.*;

public class Rocks { //ROCKS AND ROCK 1 ARE THE TOP ROCKS


    public String name;
    public int xpos;
    public int ypos;
    public int dx;
    public int dy;
    public int width;
    public int height;
    public boolean isAlive;
    public Rectangle rec;
    public boolean right;
    public boolean down;
    public boolean up;
    public boolean left;
    public boolean crossable;


    public Rocks(String pName, int pXpos, int pYpos) {
        name = pName;
        xpos = pXpos;
        ypos = pYpos;
        dx = (int) (Math.random() * 2 + 1);
        dy = (int) (Math.random() * 2 + 1);
        width = 30;
        height = 30;
        isAlive = true;
        rec = new Rectangle(xpos, ypos, width, height);

    }
    // if crossable, then make an array

    public void wrap() {
        xpos = xpos + dx;
        ypos = ypos + dy;

        if (xpos >= 1000 && dx > 0) {
            xpos = -width;

        }
        if (xpos <= -width && dx < 0) {
            xpos = 1000;

        }
        if (ypos >= 700 - height || ypos <= 350) {
            dy = -dy;

        }
        rec = new Rectangle(xpos, ypos, width, height);
    }


    public void wrap2() {
        xpos = xpos + dx;
        ypos = ypos + dy;

        if (xpos >=1000 && dx > 0){
            xpos = -width;

        }
        if (xpos <= -width && dx < 0){
            xpos = 1000;

        }
        if (ypos >= 350){
            dy = -dy;

        }
        if (ypos <= 0){
            dy = -dy;

        }
        rec = new Rectangle(xpos, ypos, width, height);
    }

//    rec = new Rectangle(xpos, ypos, width, height);

}

//    public void wrap2() { FOR THE OTHER ROCKS
//        xpos = xpos + dx;
//        ypos = ypos + dy;
//
//        if (xpos >=1000 && dx > 0){
//            xpos = -width;
//
//        }
//        if (xpos <= -width && dx < 0){
//            xpos = 1000;
//
//        }
//        if (ypos >= 350){ // MAKE THE ROCKS GO FASTER WHEN THEY HIT THE WALL OR ADD MORE ROCKS OR MAKE DIFFERENT LEVELS
//            dy = -dy;
//
//        }
//        if (ypos <= 0){
//            dy = -dy;
//
//        }
//
//    }

