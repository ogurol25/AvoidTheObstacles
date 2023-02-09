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

    public Player2(String pName, int pXpos, int pYpos) {
        name = pName;
        xpos = pXpos;
        ypos = pYpos;
        dx = (int) (Math.random() * 2 + 1);
        dy = (int) (Math.random() * 2 + 1);
        width = 100;
        height = 100;
        isAlive = true;


    }
}
