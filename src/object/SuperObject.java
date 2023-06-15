package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject 
{
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;  
    public Rectangle SolidArea = new Rectangle(0, 0, 48, 48);
    public int SolidAreaDefaultX = 0;
    public int SolidAreaDefaultY = 0;
    public int actionLockCounter = 0;
    public String monologues[] = new String[20];
    public int monologueIndex = 0;

    public void setAction(){}
    public void monologue(){}
    public void update(){}
    
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
