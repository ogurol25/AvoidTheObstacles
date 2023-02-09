
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

    public Player1 player1;
    public Player2 player2;
    public Rocks rock;

    public BasicGameApp() {

        setUpGraphics();

    }

    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp() {

            public void run() {
                while (true) {
                    crash();
                    moveThings();
                    checkIntersections();
                    render();
                    pause(5);
                }

            }

            public void keyTyped(KeyEvent e) {

            }
            public void keyPressed(KeyEvent event) {
                char key = event.getKeyChar();
                int keyCode = event.getKeyCode();
                System.out.println("Key Pressed: " + key + "  Code: " + keyCode);
            }

            public void keyReleased(KeyEvent event) {
                char key = event.getKeyChar();
                int keyCode = event.getKeyCode();

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

    }

    public void crash() {

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

        g.dispose();
        bufferStrategy.show();
    }





}