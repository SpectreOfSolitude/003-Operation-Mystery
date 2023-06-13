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
    BufferedImage keyImage;
    public Boolean messageOn = false;
    public String message = "";

    public UI(GamePanel gp)
    {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
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
        G2D.setFont(new Font("Arial", Font.PLAIN, 40));
        G2D.setColor(Color.white);
        G2D.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        G2D.drawString(" : " + gp.player.HasKey, 65, 60);

        // MESSAGE
        if (messageOn == true)
        {
            G2D.setFont(G2D.getFont().deriveFont(30F));
            G2D.drawString(message, gp.tileSize/2, gp.tileSize*5);
        }
    }

}
