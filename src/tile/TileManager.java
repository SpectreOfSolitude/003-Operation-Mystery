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
        tile = new Tile[10];
        mapTileNum= new int[gp.maxWorldHorizontal][gp.maxWorldVertical];

        getTileImage();
        loadMap();
    }

    public void getTileImage()
    {
        try 
        {
            tile [0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/grass.png"));

            tile [1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/wall.png"));
            tile[1].collision = true;

            tile [2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/water.png"));
            tile[2].collision = true;

            tile [3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/earth.png"));

            tile [4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tree.png"));
            tile[4].collision = true;

            tile [5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sand.png"));
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