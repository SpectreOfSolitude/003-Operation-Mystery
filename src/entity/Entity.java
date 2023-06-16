package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity
{
    GamePanel gp;

    public int WorldX, WorldY;
    public int speed;
    public int worldX, worldY;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public BufferedImage image;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle SolidArea = new Rectangle(0, 0, 48, 48);
    public int SolidAreaDefaultX, SolidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter = 0;
    public String dialogues[] = new String[20];
    public int dialogueIndex = 0;

    public Entity(GamePanel gp)
    {
        this.gp = gp;
    }
    
    public void setAction(){}

    public void speak(){}

    public void update()
    {
        collisionOn = false;
        gp.ColChecker.checkTile(this);
        setAction();
        
        if(collisionOn == false)
        {
            switch(direction){
                case "up" : worldY -= speed; break;
                case "down" : worldY += speed; break;
                case "left" : worldX -= speed; break;
                case "right" : worldX += speed; break;
            }
        }
        
        spriteCounter++;
        if(spriteCounter > 12)
        {
            if(spriteNum == 1)
            {
                spriteNum = 2;
            }
            else if (spriteNum == 2)
            {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2D, GamePanel gp)
    {
        BufferedImage image = null;
        int ScreenX = worldX - gp.player.WorldX + gp.player.screenX;
        int ScreenY = worldY - gp.player.WorldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.WorldX - gp.player.screenX &&
            worldX - gp.tileSize < gp.player.WorldX + gp.player.screenX &&
            worldY + gp.tileSize > gp.player.WorldY - gp.player.screenY &&
            worldY - gp.tileSize < gp.player.WorldY + gp.player.screenY)
        {
            switch(direction)
            {
                case "up":
                    if(spriteNum == 1)
                    {
                        image = up1;
                    }
                    if(spriteNum == 2)
                    {
                        image = up2;
                    }
                    break;
                case "down":
                    if(spriteNum == 1)
                    {
                        image = down1;
                    }
                    if(spriteNum == 2)
                    {
                        image = down2;
                    }
                    break;
                case "left":
                    if(spriteNum == 1)
                    {
                        image = left1;
                    }
                    if(spriteNum == 2)
                    {
                        image = left2;
                    }
                    break;
                case "right":
                    if(spriteNum == 1)
                    {
                        image = right1;
                    }
                    if(spriteNum == 2)
                    {
                        image = right2;
                    }
                    break;
            }
        }
        g2D.drawImage(image, ScreenX, ScreenY, gp.tileSize, gp.tileSize, null);
    }
}
