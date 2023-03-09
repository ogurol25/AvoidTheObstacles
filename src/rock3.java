import java.awt.*;

public class rock3 {

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

    public rock3(String pName, int pXpos, int pYpos) {
        name = pName;
        xpos = pXpos;
        ypos = pYpos;
        dx = (int) (Math.random() * 2 + 1);
        dy = (int) (Math.random() * 2 + 1);
        width = 30;
        height = 30;
        isAlive = true;


    }

    public void wrap() {
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

    }
}
