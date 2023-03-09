
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BasicGameApp implements Runnable, KeyListener {



    final int WIDTH = 1000;
    final int HEIGHT = 700;

    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;

    public Player1 play1;
    public Player2 play2;
    public Rocks rock;
    public Rocks rock1;
    public Rocks rock2;
    public Rocks rock3;
    public redportal rportal;
    public blueportal bportal;
    public StickArray[] sticks;
    public StickArray[] sticks2;
    public StickArray[] sticks3;
    public StickArray[] sticks4;

    public Image play1pic;
    public Image play2pic;
    public Image rockpic;
    public Image rock1pic;
    public Image rock2pic;
    public Image rock3pic;
    public Image scoreboardPic;
    public Image blueportal;
    public Image redportal;
    public int scoregoal1 = 0;
    public int scoregoal2 = 0;
    public Image sticksPic;
    public boolean gameStart;
    public boolean IsCrashing = false;
    public SoundFile boom;





    public BasicGameApp() {

        setUpGraphics();

        play1pic = Toolkit.getDefaultToolkit().getImage("fireboy1.png");
        play1 = new Player1("play1", 750, 200);

        boom = new SoundFile ("Explosion 01.wav");

        play2pic = Toolkit.getDefaultToolkit().getImage("watergirl1.png");
        play2 = new Player2("play2", 750, 700);

        rockpic = Toolkit.getDefaultToolkit().getImage("rock1.png");
        rock = new Rocks("rock", 100, 350);

        rock1pic = Toolkit.getDefaultToolkit().getImage("rock1.png");
        rock1 = new Rocks("rock", 100, 650);

        rock2pic = Toolkit.getDefaultToolkit().getImage("rock1.png");
        rock2 = new Rocks("rock", 250, 200);

        rock3pic = Toolkit.getDefaultToolkit().getImage("rock1.png");
        rock3= new Rocks("rock", 300, 150);

        blueportal = Toolkit.getDefaultToolkit().getImage("blueportal.png");
        bportal = new blueportal("blueportal", 0, 0);

        redportal = Toolkit.getDefaultToolkit().getImage("redportal.png");
        rportal = new redportal("redportal", 0, 600);

        scoreboardPic = Toolkit.getDefaultToolkit().getImage("first1.png");


        sticksPic = Toolkit.getDefaultToolkit().getImage("stick.png");
//        for(int x =0;x>stick.length;x=x+1){
//            sticks[x] = new StickArray();

//        NAME[0] = new Stick("Stick 1", 0, 250);
//        NAME[1] = new Stick("Stick 2", 0, 550);
//        for (int x = 1; x < sticks.length; x ++){
//            sticks[x] = new StickArray();
        }



//        sticks1 = new StickArray[0];
//        sticks2 = new StickArray[1];
//        sticks3 = new StickArray[2];
//        sticks4 = new StickArray[3];

    Stick[] NAME = new Stick[2];

    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();
        new Thread(ex).start();
    }


    public void keyPressed(KeyEvent event) {
        //This method will do something whenever any key is pressed down.
        //Put if( ) statements here
        char key = event.getKeyChar();     //gets the character of the key pressed
        int keyCode = event.getKeyCode();  //gets the keyCode (an integer) of the key pressed
        System.out.println("Key Pressed: " + key + "  Code: " + keyCode);

        if (keyCode == 10 && gameStart == false){ //enter/return key to start the game
            gameStart = true;
            scoregoal1 = 0;
            scoregoal2 = 0;
        }

        if (keyCode == 39) {
            play1.right = true;

        }
        if (keyCode == 40) {
            play1.down = true;
        }
        if (keyCode == 37) {
            play1.left = true;

        }
        if (keyCode == 38) {
            play1.up = true;
        }

        if (keyCode == 68) {
            play2.right = true;

        }
        if (keyCode == 83) {
            play2.down = true;
        }
        if (keyCode == 65) {
            play2.left = true;

        }
        if (keyCode == 87) {
            play2.up = true;
        }
        if (keyCode == 32) {

        }


    }//keyPressed()

    public void keyReleased(KeyEvent event) {
        char key = event.getKeyChar();
        int keyCode = event.getKeyCode();
        //This method will do something when a key is released
        if (keyCode == 39) {
            play1.right = false;

        }
        if (keyCode == 40) {
            play1.down = false;
        }
        if (keyCode == 37) {
            play1.left = false;

        }
        if (keyCode == 38) {
            play1.up = false;
        }
        if (keyCode == 32) {
            play1.dy = -15;
        }

        if (keyCode == 68) {
            play2.right = false;

        }
        if (keyCode == 83) {
            play2.down = false;
        }
        if (keyCode == 65) {
            play2.left = false;

        }
        if (keyCode == 87) {
            play2.up = false;
        }

    }
    public void keyTyped(KeyEvent event) {

    }

    public void run() {
        while (true) {
            if (gameStart == true){
                moveThings();
                checkIntersections();
            }

            crash();
            render();
            pause(5);
        }

    }
    public void pause(int time ) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    public void moveThings() {
        rock.wrap();
        rock1.wrap();
        rock2.wrap2();
        rock3.wrap2();

        play1.move();
        play2.move();
    }

    public void crash() {
        if (play1.rec.intersects(rock.rec) && IsCrashing == false) {
            play1.xpos = 750;
            play1.ypos = 400;
//            play2.xpos = 750;
//            play2.ypos = 200;
            rock.xpos = 100;
            rock.ypos = 350;
            rock1.xpos = 100;
            rock1.ypos = 650;
//            rock2.xpos = 250;
//            rock2.ypos = 200;
//            rock3.xpos = 300;
//            rock3.ypos = 150;
            IsCrashing = true;

        }
        if (!play1.rec.intersects(rock.rec)) {
            IsCrashing = false;
        }
        if (play1.rec.intersects(rock1.rec) && IsCrashing == false) {
            play1.xpos = 750;
            play1.ypos = 400;
//            play2.xpos = 750;
//            play2.ypos = 200;
            rock.xpos = 100;
            rock.ypos = 350;
            rock1.xpos = 100;
            rock1.ypos = 650;
//            rock2.xpos = 250;
//            rock2.ypos = 200;
//            rock3.xpos = 300;
//            rock3.ypos = 150;
            IsCrashing = true;
        }
        if (!play1.rec.intersects(rock1.rec)) {
            IsCrashing = false;

        }
//        if (play1.rec.intersects(rock2.rec) && IsCrashing == false) {
//            play1.xpos = 750;
//            play1.ypos = 400;
//            play2.xpos = 750;
//            play2.ypos = 200;
//            rock.xpos = 100;
//            rock.ypos = 350;
//            rock1.xpos = 100;
//            rock1.ypos = 650;
//            rock2.xpos = 250;
//            rock2.ypos = 200;
//            rock3.xpos = 300;
//            rock3.ypos = 150;
//            IsCrashing = true;
//        }
//        if (!play1.rec.intersects(rock2.rec)) {
//            IsCrashing = false;
//
//        }
//        if (play1.rec.intersects(rock3.rec) && IsCrashing == false) {
//            play1.xpos = 750;
//            play1.ypos = 400;
//            play2.xpos = 750;
//            play2.ypos = 200;
//            rock.xpos = 100;
//            rock.ypos = 350;
//            rock1.xpos = 100;
//            rock1.ypos = 650;
//            rock2.xpos = 250;
//            rock2.ypos = 200;
//            rock3.xpos = 300;
//            rock3.ypos = 150;
//            IsCrashing = true;
//        }
//        if (!play1.rec.intersects(rock3.rec)) {
//            IsCrashing = false;
//
//        }
//        if (play2.rec.intersects(rock.rec) && IsCrashing == false) {
//            play1.xpos = 750;
//            play1.ypos = 400;
//            play2.xpos = 750;
//            play2.ypos = 200;
//            rock.xpos = 100;
//            rock.ypos = 350;
//            rock1.xpos = 100;
//            rock1.ypos = 650;
//            rock2.xpos = 250;
//            rock2.ypos = 200;
//            rock3.xpos = 300;
//            rock3.ypos = 150;
//            IsCrashing = true;
//        }
//        if (!play2.rec.intersects(rock.rec)) {
//            IsCrashing = false;
//
//        }
//        if (play2.rec.intersects(rock1.rec) && IsCrashing == false) {
//            play1.xpos = 750;
//            play1.ypos = 400;
//            play2.xpos = 750;
//            play2.ypos = 200;
//            rock.xpos = 100;
//            rock.ypos = 350;
//            rock1.xpos = 100;
//            rock1.ypos = 650;
//            rock2.xpos = 250;
//            rock2.ypos = 200;
//            rock3.xpos = 300;
//            rock3.ypos = 150;
//            IsCrashing = true;
//        }
//        if (!play2.rec.intersects(rock1.rec)) {
//            IsCrashing = false;
//
//        }
        if (play2.rec.intersects(rock2.rec) && IsCrashing == false) {
//            play1.xpos = 750;
//            play1.ypos = 400;
            play2.xpos = 750;
            play2.ypos = 200;
//            rock.xpos = 100;
//            rock.ypos = 350;
//            rock1.xpos = 100;
//            rock1.ypos = 650;
            rock2.xpos = 250;
            rock2.ypos = 200;
            rock3.xpos = 300;
            rock3.ypos = 150;
            IsCrashing = true;
        }
        if (!play2.rec.intersects(rock2.rec)) {
            IsCrashing = false;

        }
        if (play2.rec.intersects(rock3.rec) && IsCrashing == false) {
//            play1.xpos = 750;
//            play1.ypos = 400;
            play2.xpos = 750;
            play2.ypos = 200;
//            rock.xpos = 100;
//            rock.ypos = 350;
//            rock1.xpos = 100;
//            rock1.ypos = 650;
            rock2.xpos = 250;
            rock2.ypos = 200;
            rock3.xpos = 300;
            rock3.ypos = 150;
            IsCrashing = true;
        }
        if (!play2.rec.intersects(rock3.rec)) {
            IsCrashing = false;
        }
//        if (play2.rec.intersects(rock3.rec) && IsCrashing == false) {
//            play1.xpos = 750;
//            play1.ypos = 350;
//            play2.xpos = 500;
//            play2.ypos = 350;
//            rock.xpos = 100;
//            rock.ypos = 350;
//            rock1.xpos = 100;
//            rock1.ypos = 650;
//            rock2.xpos = 250;
//            rock2.ypos = 200;
//            rock3.xpos = 300;
//            rock3.ypos = 150;
//            IsCrashing = true;
//        }
//        if (!play2.rec.intersects(rock3.rec)) {
//            IsCrashing = false;
//        }
        if (play1.rec.intersects(rportal.rec) && IsCrashing == false) {
            play1.xpos = 750;
            play1.ypos = 350;
//            play2.xpos = 500;
//            play2.ypos = 350;
//            rock.xpos = 100;
//            rock.ypos = 350;
//            rock1.xpos = 100;
//            rock1.ypos = 650;
            rock2.xpos = 250;
            rock2.ypos = 200;
            rock3.xpos = 300;
            rock3.ypos = 150;
            IsCrashing = true;
            scoregoal1 = scoregoal1 + 1;
            boom.play();
        }
        if (!play1.rec.intersects(rportal.rec)) {
            IsCrashing = false;
        }
        if (play2.rec.intersects(bportal.rec) && IsCrashing == false) {
//            play1.xpos = 750;
//            play1.ypos = 350;
            play2.xpos = 500;
            play2.ypos = 350;
            rock.xpos = 100;
            rock.ypos = 350;
            rock1.xpos = 100;
            rock1.ypos = 650;
//            rock2.xpos = 250;
//            rock2.ypos = 200;
//            rock3.xpos = 300;
//            rock3.ypos = 150;
            IsCrashing = true;
            scoregoal2 = scoregoal2 + 1;
            boom.play();
            
        }
        if (!play2.rec.intersects(bportal.rec)) {
            IsCrashing = false;
        }
        if (scoregoal1 == 10){
            gameStart = false;
        }
        if (scoregoal2 == 10){
            gameStart = false;
        }
    }

    public void checkIntersections() {

    }

    private void setUpGraphics() {
        frame = new JFrame("Application Template");

        panel = (JPanel) frame.getContentPane();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setLayout(null);   //set the layout


        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);
        canvas.addKeyListener(this);

        panel.add(canvas);

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);


        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }

    void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        if (gameStart == false) {
            g.setColor(Color.green);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.white);
            g.drawString("Press enter to start", 450, 350);
        } else {

            g.drawImage(play1pic, play1.xpos, play1.ypos, play1.width, play1.height, null);
            g.drawImage(play2pic, play2.xpos, play2.ypos, play2.width, play2.height, null);
            g.drawImage(rockpic, rock.xpos, rock.ypos, rock.width, rock.height, null);
            g.drawImage(rock1pic, rock1.xpos, rock1.ypos, rock1.width, rock1.height, null);
            g.drawImage(rock2pic, rock2.xpos, rock2.ypos, rock2.width, rock2.height, null);
            g.drawImage(rock3pic, rock3.xpos, rock3.ypos, rock3.width, rock3.height, null);
            g.drawImage(blueportal, 0, 0, 70, 70, null);
            g.drawImage(redportal, 0, 600, 90, 75, null);
//            g.drawImage(sticks1, 10, 200, 75, 75, null);

            g.setColor(Color.RED);
            g.setFont(new Font("TimesRoman", Font.BOLD, 25));
            g.drawString(String.valueOf(scoregoal1), 90, 650);
            g.setColor(Color.BLUE);
            g.setFont(new Font("TimesRoman", Font.BOLD, 25));
            g.drawString(String.valueOf(scoregoal2), 80, 45);

            g.drawImage(scoreboardPic, 500,0, 100, 100, null);

        }

        g.dispose();
        bufferStrategy.show();

    }
}