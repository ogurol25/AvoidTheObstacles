
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class BasicGameApp implements Runnable, KeyListener {



    final int WIDTH = 1000;
    final int HEIGHT = 700;

    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;

    public Player1 play1;
    public Player2 play2;
    public Rocks rock;
    public rock1 rock1;
    public rock2 rock2;
    public rock3 rock3;

    public Image play1pic;
    public Image play2pic;
    public Image rockpic;
    public Image rock1pic;
    public Image rock2pic;
    public Image rock3pic;
    public Image blueportal;
    public Image redportal;
    public boolean gameStart;



    public BasicGameApp() {

        setUpGraphics();

        play1pic = Toolkit.getDefaultToolkit().getImage("fireboy1.png");
        play1 = new Player1("play1", 500, 350);

        play2pic = Toolkit.getDefaultToolkit().getImage("watergirl1.png");
        play2 = new Player2("play2", 750, 350);

        rockpic = Toolkit.getDefaultToolkit().getImage("rock1.png");
        rock = new Rocks("rock", 100, 350);

        rock1pic = Toolkit.getDefaultToolkit().getImage("rock1.png");
        rock1 = new rock1("rock", 100, 650);

        rock2pic = Toolkit.getDefaultToolkit().getImage("rock1.png");
        rock2 = new rock2("rock", 250, 200);

        rock3pic = Toolkit.getDefaultToolkit().getImage("rock1.png");
        rock3= new rock3("rock", 300, 150);

        blueportal = Toolkit.getDefaultToolkit().getImage("blueportal.png");

        redportal = Toolkit.getDefaultToolkit().getImage("redportal.png");

    }

    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp() {

            public void keyPressed(KeyEvent event) {
                //This method will do something whenever any key is pressed down.
                //Put if( ) statements here
                char key = event.getKeyChar();     //gets the character of the key pressed
                int keyCode = event.getKeyCode();  //gets the keyCode (an integer) of the key pressed
                System.out.println("Key Pressed: " + key + "  Code: " + keyCode);

                if (keyCode == 10 && gameStart == false){ //enter/return key to start the game
                    gameStart = true;
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

        };
        new Thread(ex).start();
    }

    public void pause(int time ) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    public void moveThings() {
    rock.wrap();
    play1.move();
    play2.move();
    }

    public void crash() {
//        if (sponge.rec.intersects(ball.topHitBox) && IsTopCrashing == false){
//            sponge.dy=-sponge.dy;
//            ball.dy=-ball.dy;
//            IsTopCrashing = true;
//
//        }
//        if(!sponge.rec.intersects(ball.topHitBox)){
//            IsTopCrashing = false;
//        }
//        if (sponge.rec.intersects(ball.bottomHitBox) && IsBottomCrashing == false){
//            sponge.dy=-sponge.dy;
//            ball.dy=-ball.dy;
//            IsBottomCrashing = true;
//
//        }
//        if(!sponge.rec.intersects(ball.bottomHitBox)){
//            IsBottomCrashing = false;
//        }



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
            g.drawImage(blueportal, 0, 0, 70, 70, null);
            g.drawImage(redportal, 0, 600, 90, 75, null);
        }

            g.dispose();
            bufferStrategy.show();

    }
}