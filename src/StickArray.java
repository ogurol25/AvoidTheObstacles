


public class StickArray {
    public int[] sticks;
    public StickArray[] sticks1;
    public StickArray[] sticks2;
    public int xpos;
    public int ypos;
    public int dx;



    public StickArray() {

        sticks = new int[4];

        for (int x = 1; x < 4; x ++){
            sticks1[x] = new StickArray();
        }

        for (int x = 1; x < sticks2.length; x ++){
            sticks2[x] = new StickArray();
        }

    }

//    public class move(){
//        xpos = xpos + dx;
//    }
}