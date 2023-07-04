package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.KEY;

public class UI 
{
    GamePanel gp;
    Graphics2D G2D;
    Font arial_40;
    Font arial_80;
    BufferedImage keyImage;
    public Boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";

    public UI(GamePanel gp)
    {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_40 = new Font("Arial", Font.BOLD, 80);
        KEY key = new KEY(gp);
        keyImage = key.image;
    }

    public void showMessage(String text)
    {
        message = text;
        messageOn = true;
    }

    public void draw (Graphics2D G2D)
    {
        this.G2D = G2D;

        if(gp.gameState == gp.playState)
        {
            // playstate stuff
        }

        if(gp.gameState == gp.pauseState)
        {
            DrawPauseScreen();    
        }

        if (gp.gameState == gp.dialogueState)
        {
            DrawDialogueScreen();
        }

        if (gameFinished == true)
        {
            gp.gameState = gp.endState;
            DrawEndScreen();
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

        public void DrawEndScreen()
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

    public void DrawPauseScreen()
    {
        String text = "PAUSED";
        
        G2D.setFont(G2D.getFont().deriveFont(Font.PLAIN, 80));
        G2D.setColor(Color.white);
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        G2D.drawString(text, x, y);
    }    

    public void DrawDialogueScreen()
    {
        int x = gp.tileSize*2;
        int y = gp.tileSize*7;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*4;

        drawSubWindow(x, y, width, height);

        G2D.setFont(G2D.getFont().deriveFont(Font.PLAIN,32F));
        x = x + gp.tileSize;
        y = y + gp.tileSize;

        for(String line : currentDialogue.split("\n"))
        {
            G2D.drawString(line, x, y);
            y = y + 40;
        }
    }

    private void drawSubWindow(int x, int y, int width, int height)
    {
        Color WindowColor = new Color (0, 0, 0, 210);
        G2D.setColor(WindowColor);
        G2D.fillRoundRect(x, y, width, height, 35, 35);

        WindowColor = new Color (255, 255, 255);
        G2D.setColor(WindowColor);
        G2D.setStroke(new BasicStroke(5));
        G2D.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    }

    private int getXforCenteredText(String text)
    {
        int x;
        int length = (int)G2D.getFontMetrics().getStringBounds(text, G2D).getWidth();
        x = gp.screenWidth/2 - length/2;
        return x;
    }
}
