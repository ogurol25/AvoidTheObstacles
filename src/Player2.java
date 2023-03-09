import java.awt.*;

public class Player2 {

    public String name;
    public int xpos;
    public int ypos;
    public int dx;
    public int dy;
    public int width;
    public int height;
    public boolean isAlive;
    public boolean right;
    public boolean down;
    public boolean up;
    public boolean left;
    public Rectangle rec;

    public Player2(String pName, int pXpos, int pYpos) {
        name = pName;
        xpos = pXpos;
        ypos = pYpos;
        dx = (int) (Math.random() * 2 + 1);
        dy = (int) (Math.random() * 2 + 1);
        width = 100;
        height = 100;
        isAlive = true;
        rec = new Rectangle(xpos, ypos, width, height);

    }

    public void move() {

        xpos = xpos + dx;
        ypos = ypos + dy;

        if (right == true) {
            dx = 2;

        }else if (left == true){
            dx=-2;
        }else {
            dx=0;
        }

        if (down == true) {
            dy=2;
        } else if (up == true){
            dy = -2;
        }else {
            dy=0;
        }

        if(xpos>1025-width){
            xpos=1025-width;
        }

        if(xpos<0){
            xpos = 0;
        }
        if (ypos>350-height){
            ypos=350-height;
        }
        if (ypos<0){
            ypos=0;
        }
        rec = new Rectangle(xpos, ypos, width, height);


    }
}
