package entity;

import java.awt.Rectangle;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class yuki extends Entity {
    public yuki (GamePanel gp)
    {
        super(gp);

        setDefaultValues();
        direction = "down";
        speed = 1;
        getPlayerImage();
        
    }
  
    public void setDefaultValues()
    {
        SolidArea = new Rectangle();
        SolidArea.x = 6;
        SolidArea.y = 12;
        SolidAreaDefaultX = SolidArea.x;
        SolidAreaDefaultY = SolidArea.y;
        SolidArea.width = 24;
        SolidArea.height = 24;
    }

    public void getPlayerImage()
    {
        try 
        {
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/NPC/npcTop_step1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/NPC/npcTop_step2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/NPC/npcBot_step1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/NPC/npcBot_step2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/NPC/npcLeft_step1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/NPC/npcLeft_step2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/NPC/npcRight_step1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/NPC/npcRight_step2.png"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public void setAction(){
        actionLockCounter++;

        if(actionLockCounter == 120){
            Random random = new Random();
            int i = random.nextInt(100)+1; // pick up a number from 1 to 100

            if(i <= 25){
                direction = "up";
            }

            if(i > 25 && i <= 50){
                direction = "down";
            }
            if(i > 50 && i <= 75){
                direction = "left";
            }
            if(i > 75 && i <= 100){
                direction = "right";
            }
        }

        
        
    }
}
