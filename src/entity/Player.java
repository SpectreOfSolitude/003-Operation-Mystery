package entity;

import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.*;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity 
{
    GamePanel gp;
    KeyHandler keyH;   
    
    public final int screenX;
    public final int screenY;
    
    public Player(GamePanel gp, KeyHandler keyH)
    {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2- (gp.tileSize/2);

        SolidArea = new Rectangle(8, 16, 32, 32);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues()
    {
        WorldX = gp.tileSize*10;
        WorldY = gp.tileSize*8;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage()
    {
        try 
        {
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boyup1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boyup2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boydown1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boydown2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boyleft1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boyleft2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boyright1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boyright2.png"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public void update()
    {
        if (keyH.upPressed == true || keyH.downPressed == true || 
        keyH.leftPressed == true || keyH.rightPressed == true)
        {

            if(keyH.upPressed == true)
            {
            direction = "up";
            
        }

        if(keyH.downPressed == true)
        {
            direction = "down";

        }
        
        if(keyH.leftPressed == true)
        {
            direction = "left";

        }
        
        if(keyH.rightPressed)
        {
            direction = "right";

        }

        // CHECKING TILE COLLISION
        collisionOn = false;
        gp.ColChecker.checkTile(this);

        // IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(collisionOn == false)
        {
            if (direction == "up")
            {
                WorldY = WorldY - speed;
            }
            if (direction == "down")
            {
                WorldY = WorldY + speed;
            }
            if (direction == "left")
            {
                WorldX = WorldX - speed;  
            }
            if (direction == "right")
            {
                WorldX = WorldX + speed;    
            }
        }
        
        spriteCounter = spriteCounter + 1;
        if(spriteCounter > 12)
        {
            if(spriteNum == 1)
            {
                spriteNum =2;
            }
            else if (spriteNum == 2)
            {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
}

    public void draw(Graphics2D G2D)
    {
        // G2D.setColor(Color.white);
        // G2D.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

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
        G2D.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
