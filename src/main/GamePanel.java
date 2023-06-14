package main;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable
{
    // SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;

    // SCREEN SETTTTINGS
    public final int tileSize = originalTileSize * scale; //48x48 tile
    public final int maxScreenHorizontal = 16;
    public final int maxScreenVertical = 12;
    public final int screenWidth = tileSize * maxScreenHorizontal; // 786px
    public final int screenHeight = tileSize * maxScreenVertical; // 576px

    // WORLD SETTINGS
    public final int maxWorldHorizontal = 50;
    public final int maxWorldVertical = 50;
    //public final int worldWidth = tileSize * maxWorldHorizontal;   THIS ISN'T USED ANYMORE
    //public final int worldHeight = tileSize * maxWorldVertical;   THIS ISN'T USED ANYMORE

    // FPS
    int FPS = 60;

    // TileManager 
    TileManager tileM = new TileManager(this);

    // KeyHandler
    KeyHandler keyH = new KeyHandler();

    // AUDIO
    Sound BGM = new Sound();
    Sound SE = new Sound();

    // Collision Checker
    public CollisionChecker ColChecker = new CollisionChecker(this);

    // Game Thread
    Thread gameThread;

    //Object Placement On the Map
    public ObjectPlacement ObjectMapping = new ObjectPlacement(this);

    // UI
    public UI ui = new UI(this);

    // Player
    public Player player = new Player(this,keyH);

    // Object
    public SuperObject obj[] = new SuperObject[30];

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void SetUpGame()
    {
        ObjectMapping.setObject();
        PlayMusic(0);
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override // Delta Accumulator Method
    public void run()
    {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        // FPS SETTINGS
        while (gameThread != null)
        {
            currentTime = System.nanoTime();
            delta = delta + (currentTime - lastTime)/drawInterval;
            timer = timer + (currentTime - lastTime);

            lastTime = currentTime;

            if (delta >= 1)
            {
                
                update();

                repaint();

                delta = delta - 1;
                drawCount = drawCount + 1;
            }

            if(timer >= 100000000)
            {
                System.out.println("FPS: " +drawCount*10);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    // @Override
    // public void run()
    // {

    //     double drawInterval = 1000000000/FPS; // 0.01666 seconds
    //     double nextDrawTime = System.nanoTime() + drawInterval;

    //     while (gameThread != null)
    //     {

    //         update();
            
    //         repaint();

            
    //         try 
    //         {
    //             double remainingTime = nextDrawTime - System.nanoTime();
    //             remainingTime = remainingTime/1000000;

    //             if(remainingTime < 0)
    //             {
    //                 remainingTime = 0;
    //             }

    //             Thread.sleep((long) remainingTime);

    //             nextDrawTime = nextDrawTime + drawInterval;
    //         } 
    //         catch (InterruptedException e) 
    //         {
    //             e.printStackTrace();
    //         }
    //     }
    //     //Diisi dengan GameLoop
    // }

    public void update()
    {
       player.update();
    }

    public void paintComponent(Graphics graph)
    {
        super.paintComponent(graph);

        Graphics2D g2D = (Graphics2D)graph;
        
        //tiles
        tileM.draw(g2D);
        
        //objects
        for(int i = 0; i < obj.length; i++)
        {
            if (obj[i] != null)
            {
                obj[i].draw(g2D, this);
            }
        }

        //player
        player.draw(g2D);

        ui.draw(g2D);
        g2D.dispose();
    }

    public void PlayMusic(int i)
    {
        BGM.setFile(i);
        BGM.play();
        BGM.loop();
    }

    public void stopMusic ()
    {
        BGM.stop();
    }

    public void playSE(int i)
    {
        SE.setFile(i);
        SE.play();
    }
}