import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //screen settings
    final int originaltilesize = 16;//means 16 by 16 tile = player size npc map tile
    final int scale = 3;//= 16 * 3 so 48 pixels

    final int tilesize = originaltilesize * scale;//basicaly tile size 48 by 48
    //so max 16 in a coloum
    final int maxscreencol = 16;
    // so 12 in a row
    final int maxscreenrow = 12;
    final int screenWidth = tilesize * maxscreencol;// 768 pixels wide
    final int screenHeight = tilesize * maxscreenrow; // 576 pixels long

    Thread gameThread;// keeps my programs runing untill i stop it

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));// telling a new dimension
        this.setBackground(Color.black);// setting background color
        this.setDoubleBuffered(true);

    }

    public void startGameThread() {

        gameThread = new Thread(this);// declaring a nw thread
        gameThread.start();// telling the thread to start
    }

    @Override
    public void run() {//gamethread caller

        while (gameThread != null) {//this is telling java that as long as this thread exist keep running what is in the  curly brackets

            //    System.out.println("game loop is running");

            // 1 Update : update information such as chararecter infmation
            update();

            // Draw : draw the screen with the updated information
            repaint();// how you call the paintcomponent method
        }
    }

    public void update() {
    }

    public void paintComponent(Graphics g) {// to tell java hey man I want to draw the updated picture
        super.paintComponent(g);// super  is the parent class of this class // cause when ever I type paint component I need this
        Graphics2D g2 = (Graphics2D) g;// has little more functitions than graphics
        g2.setColor(Color.white);// setting color
        g2.fillRect(100, 100, tilesize, tilesize);// draws a rectangle on the screen
        g2.dispose();// good practice


    }
}

