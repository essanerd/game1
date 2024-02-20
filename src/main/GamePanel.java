package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //screen settings
    final int originalTileSize = 16;//means 16 by 16 tile = player size npc map tile
    final int scale = 3;//= 16 * 3 so 48 pixels

    final int tileSize = originalTileSize * scale;//basicaly tile size 48 by 48
    //so max 16 in a coloum
    final int maxscreencol = 16;
    // so 12 in a row
    final int maxscreenrow = 12;
    final int screenWidth = tileSize * maxscreencol;// 768 pixels wide
    final int screenHeight = tileSize * maxscreenrow; // 576 pixels long
    // fps
    int FPS = 60;
    KeyHandler keyH = new KeyHandler();// declaring a new key handler

    Thread gameThread;// keeps my programs runing untill i stop it

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));// telling a new dimension
        this.setBackground(Color.black);// setting background color
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);// so it can recognize the key input
        this.setFocusable(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);// declaring a nw thread
        gameThread.start();// telling the thread to start
    }

    // set player`s default posititon
    int PlayerX = 100;
    int PlayerY = 100;
    int Playerspeed = 4;


    public void run() {//gamethread caller
        double drawInterval = 1000000000 / FPS;// draw the screen every 0.016666666666666
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {//this is telling java that as long as this thread exist keep running what is in the  curly brackets

            long currentTime = System.nanoTime();
            System.out.println("current time:" + currentTime);

            // 1 Update : update information such as chararecter infmation
            update();


            repaint();// how you call the paintcomponent method


            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;


                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime); // pause`s the game loop untill it`s sleep time is over
                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                // TODO Auto generated catch block
                e.printStackTrace();
            }


        }
    }

    public void update() {
        if (keyH.upPressed == true) {//all  of  these updates player positions
            PlayerY -= Playerspeed;
        } else if (keyH.downPressed == true) {
            PlayerY += Playerspeed;
        } else if (keyH.leftPressed == true) {
            PlayerX -= Playerspeed;
        } else if (keyH.rightPressed == true) {
            PlayerX += Playerspeed;
        }
    }

    public void paintComponent(Graphics g) {// to tell java hey man I want to draw the updated picture
        super.paintComponent(g);// super  is the parent class of this class // cause when ever I type paint component I need this
        Graphics2D g2 = (Graphics2D) g;// has little more functitions than graphics
        g2.setColor(Color.white);// setting color
        g2.fillRect(PlayerX, PlayerY, tileSize, tileSize);// draws a rectangle on the screen
        g2.dispose();// good practice


    }
}

