package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.KEY;

public class UI 
{
    GamePanel gp;
    Font arial_40;
    Font arial_80;
    BufferedImage keyImage;
    public Boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    public UI(GamePanel gp)
    {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_40 = new Font("Arial", Font.BOLD, 80);
        KEY key = new KEY();
        keyImage = key.image;
    }

    public void showMessage(String text)
    {
        message = text;
        messageOn = true;
    }

    public void draw (Graphics2D G2D)
    {
        if (gameFinished == true)
        {
            String text;
            int textLength;
            
            
            G2D.setFont(new Font("Arial", Font.PLAIN, 40));
            G2D.setColor(Color.white);
            text = "Rakesh will be back...";
            textLength = (int)G2D.getFontMetrics().getStringBounds(text, G2D).getWidth();
            int y = gp.screenHeight/2 - (gp.tileSize*3);
            int x = gp.screenWidth/2 - textLength/2;
            G2D.drawString(text, x, y);

        }

        else
        {
            
            G2D.setFont(new Font("Arial", Font.PLAIN, 40));
            G2D.setColor(Color.white);
            G2D.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            G2D.drawString(" : " + gp.player.HasKey, 65, 60);
    
            // MESSAGE
            if (messageOn == true)
            {
                G2D.setFont(G2D.getFont().deriveFont(30F));
                G2D.drawString(message, gp.tileSize/2, gp.tileSize*5);
    
                messageCounter++;
            }
    
            if(messageCounter > 120) 
            {
                messageCounter = 0;
                messageOn = false;
            }
        }

    }

}
