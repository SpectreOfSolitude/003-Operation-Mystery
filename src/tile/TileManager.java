package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.*;
import main.GamePanel;

public class TileManager
{
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp)
    {
        this.gp = gp;
        tile = new Tile[30];
        mapTileNum= new int[gp.maxWorldHorizontal][gp.maxWorldVertical];

        getTileImage();
        loadMap();
    }

    public void getTileImage()
    {
        try 
        {
            tile [6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/grass.png"));

            tile [1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/wall.png"));
            tile[1].collision = true;

            tile [2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/water.png"));
            tile[2].collision = true;

            tile [3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Floor5.png"));

            tile [4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tree.png"));
            tile[4].collision = true;
            
            tile [5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Floor5.png"));

            tile [0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Floor5.png"));

            tile [7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Wall3_1.png"));
            tile[7].collision = true;

            tile [8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Wall3_2.png"));
            tile[8].collision = true;

            tile [10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Wall3_3.png"));
            tile[10].collision = true;

            tile [11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Wall3_4.png"));
            tile[11].collision = true;

            tile [12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Wall3_5.png"));
            tile[12].collision = true;

            tile [13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Wall3_6.png"));
            tile[13].collision = true;

            tile [14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Wall3_7.png"));
            tile[14].collision = true;

            tile [15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Wall3_8.png"));
            tile[15].collision = true;

            tile [9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/air.png"));
        
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public void loadMap()
    {
        try 
        {
            InputStream mapping = getClass().getResourceAsStream("/res/maps/map002.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(mapping));

            int horizontal = 0;
            int vertical = 0;

            while (horizontal < gp.maxWorldHorizontal && vertical < gp.maxWorldVertical)
            {
                String line = br.readLine();

                while (horizontal <gp.maxWorldHorizontal) 
                {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[horizontal]);

                    mapTileNum[horizontal][vertical] = num;
                    horizontal++;
                }

                if(horizontal == gp.maxWorldHorizontal)
                {
                    horizontal = 0;
                    vertical++;
                }
            }
        } 
        catch (Exception e) 
        {
        
        }
    }

    public void draw(Graphics2D g2D)
    {
        int WorldHorizontal = 0;
        int WorldVertical = 0;

        while(WorldHorizontal < gp.maxWorldHorizontal && WorldVertical < gp.maxWorldVertical)
        {

            int tileNum = mapTileNum[WorldHorizontal][WorldVertical];

            int WorldX = WorldHorizontal * gp.tileSize;
            int WorldY = WorldVertical * gp.tileSize;
            int ScreenX = WorldX - gp.player.WorldX + gp.player.screenX;
            int ScreenY = WorldY - gp.player.WorldY + gp.player.screenY;

            if (WorldX + gp.tileSize > gp.player.WorldX - gp.player.screenX &&
                WorldX - gp.tileSize < gp.player.WorldX + gp.player.screenX &&
                WorldY + gp.tileSize > gp.player.WorldY - gp.player.screenY &&
                WorldY - gp.tileSize < gp.player.WorldY + gp.player.screenY)
            {
                g2D.drawImage(tile[tileNum].image, ScreenX, ScreenY, gp.tileSize, gp.tileSize, null);
            }
            WorldHorizontal++;
    
            if (WorldHorizontal == gp.maxWorldHorizontal)
            {
                WorldHorizontal = 0;
                WorldVertical++;
            }
                
        }
    }

}