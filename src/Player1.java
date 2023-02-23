import java.awt.*;

public class Player1<right> {

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

    public Player1(String pName, int pXpos, int pYpos) {
        name = pName;
        xpos = pXpos;
        ypos = pYpos;
        dx = (int) (Math.random() * 2 + 1);
        dy = (int) (Math.random() * 2 + 1);
        width = 100;
        height = 100;
        isAlive = true;


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
        if (ypos>700-height){
            ypos=700-height;
        }
        if (ypos<350){
            ypos=350;
        }


    }

    }
