package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI 
{
    GamePanel gp;
    Font arial_40;

    public UI(GamePanel gp)
    {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
    }

    public void draw (Graphics2D G2D)
    {
        G2D.setFont(new Font("Arial", Font.PLAIN, 40));
        G2D.setColor(Color.white);
        G2D.drawString("Key: ", 25, 50);
    }
}
