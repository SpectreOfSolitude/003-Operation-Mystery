package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject 
{
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;  
    
    public void draw(Graphics2D G2D, GamePanel gp)
    {
        int ScreenX = worldX - gp.player.WorldX + gp.player.screenX;
        int ScreenY = worldY - gp.player.WorldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.WorldX - gp.player.screenX &&
            worldX - gp.tileSize < gp.player.WorldX + gp.player.screenX &&
            worldY + gp.tileSize > gp.player.WorldY - gp.player.screenY &&
            worldY - gp.tileSize < gp.player.WorldY + gp.player.screenY)
        {
            G2D.drawImage(image, ScreenX, ScreenY, gp.tileSize, gp.tileSize, null);
        }
    }
}
