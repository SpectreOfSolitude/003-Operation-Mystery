package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity
{
    GamePanel gp;
    public int WorldX, WorldY;
    public int speed;
    
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    
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
    
    public void setAction()
    {

    }

    public void speak()
    {

    }

    public void update()
    {
        
    }
}
